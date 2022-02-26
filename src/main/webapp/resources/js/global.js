// datatable
(function ($) {
    $.fn.MyDataTable = function (options) {
        var settings = $.extend({
            defaultFilter: true,
            columns: null,
            order: [],
            number: true,
            getDataRequest: null,
            rowCallback: null,
            autoWidth : false,
            pageLength : 10,
            displayStart : 1,
            dataSearch : ''
        }, options);

        return this.each(function () {
        	if (settings.columns) {
                var dataSource = $(this).data('url');
                var baseUrl = window.location.origin + window.location.pathname;
                var splitUrl = baseUrl.split('/');
                var name = $(this).attr('id');
                var formFilter = $('#filter-' + name);
                var datafilter = {};

                var table = $(this).DataTable({
                    serverSide: true,
                    processing: true,
                    columns: options.columns,
                    order: options.order,
                    autoWidth: settings.autoWidth,
                    ajax: {
                        url: dataSource,
                        type: 'POST',
                        datatype: 'json',
                        contentType: 'application/json',
                        data: function (data) {
                            $.each(formFilter.serializeArray(), function (index, val) {
                                datafilter[val.name] = val.value;
                            });
                            var setting = $.extend({}, data, datafilter);
                            
                            if (settings.getDataRequest) {
                        		settings.getDataRequest.call($(this), JSON.stringify(setting));
                            	$('#' + name).on('search.dt', function () {
                            		settings.getDataRequest.call($(this), JSON.stringify(setting));
                            	});
                            }
                            return JSON.stringify(setting);
                        },
                        error: function (xhr, error, thrown) {
                            console.log(xhr.statusText);
                        }
                    },
//                    language: {
//    					"searchPlaceholder" : 'Masukkan kata kunci',
//    					"sProcessing" : "Sedang memproses...",
//    					"sLengthMenu" : "Tampilkan _MENU_ data",
//    					"sZeroRecords" : "Tidak ditemukan data yang sesuai",
//    					"sInfo" : "Menampilkan _START_ sampai _END_ dari _TOTAL_ data",
//    					"sInfoEmpty" : "Menampilkan 0 sampai 0 dari 0 data",
//    					"sInfoFiltered" : "",
//    					"sInfoPostFix" : "",
//    					"sSearch" : "Cari:",
//    					"sUrl" : "",
//    					"oPaginate" : {
//    						"sFirst" : "Pertama",
//    						"sPrevious" : "Sebelumnya",
//    						"sNext" : "Selanjutnya",
//    						"sLast" : "Terakhir"
//    					}
//                    },
                    rowCallback: function(row, data, index) {
                    	if (settings.number) {
                            var info = this.api();
                            var number = info.context[0]._iDisplayStart + (index + 1);
                            $('td:eq(0)', row).html(number);
                        }
                    	if (settings.rowCallback) {
                    		settings.rowCallback.call($(this), row, data, index);
                    	}
                    },
                    pageLength : settings.pageLength,
                    displayStart : (settings.displayStart - 1) * settings.pageLength,
                    search: {
                    	search : settings.dataSearch
                    }
                });

                if (!settings.defaultFilter) {
                    $('#' + name + '_filter').hide();
                }

                function search(v) {
                    table.search(v).draw();
                }
                
                $('#' + name + ' tbody').on('click', '.details-control', function (e) {
                    e.preventDefault();

                    var tr = $(this).closest('tr');
                    var row = table.row(tr);
                    var source = $(this).data('url');
                    var start = $(this).data('start');

                    if (row.child.isShown()) {
                        row.child.hide();
                        tr.removeClass('shown');
                        $(this).attr('data-original-title', 'Detail').html('<i class="fa fa-plus"></i>');
                    } else {
                        row.child(format(name, start)).show();
                        loadChild(name, start, source);
                        tr.addClass('shown');
                        $(this).attr('data-original-title', 'Tutup').html('<i class="fa fa-minus"></i>');
                    }
                });

                function format(name, start) {
                    return '<div id="row-details-' + name + '-' + start + '"></div>';
                }

                function loadChild(name, start, source) {
                    var detail = $('#row-details-' + name + '-' + start);
                    detail.html('Silahkan tunggu...');
                    $.ajax({
                        type: 'GET',
                        url: source,
                        data: null,
                        success: function (data) {
                            detail.html(data);
                        },
                        error: function (data) {
                            console.log(data.statusText);
                        }
                    });
                }
                
                // begin filter
                formFilter.find('.enter-filter').keypress(function (e) {
                    if (e.which === 13) {
                        e.preventDefault();
                        search($(this).val());
                    }
                });

                formFilter.find('.change-filter').on('change', function () {
                    search($(this).val());
                });
                // end filter

                formFilter.find('.refresh-filter').on('click', function () {
                    formFilter[0].reset();
                    var searchChange = formFilter.find('.change-filter');
                    if (searchChange.length > 0) {
                        searchChange.trigger('change');
                    } else {
                        table.draw();
                    }
                });

                formFilter.find('.refresh-table').on('click', function () {
                    table.draw();
                });
        	} else {
        		$(this).DataTable({
//        			 language: {
//     					"searchPlaceholder" : 'Masukkan kata kunci',
//     					"sProcessing" : "Sedang memproses...",
//     					"sLengthMenu" : "Tampilkan _MENU_ data",
//     					"sZeroRecords" : "Tidak ditemukan data yang sesuai",
//     					"sInfo" : "Menampilkan _START_ sampai _END_ dari _TOTAL_ data",
//     					"sInfoEmpty" : "Menampilkan 0 sampai 0 dari 0 data",
//     					"sInfoFiltered" : "",
//     					"sInfoPostFix" : "",
//     					"sSearch" : "Cari:",
//     					"sUrl" : "",
//     					"oPaginate" : {
//     						"sFirst" : "Pertama",
//     						"sPrevious" : "Sebelumnya",
//     						"sNext" : "Selanjutnya",
//     						"sLast" : "Terakhir"
//     					}
//                     }
        		});
        	}
        });
    };
}(jQuery));

function reloadDatatable(index) {
    var table = $(index).DataTable();
    table.ajax.reload(null, false);
}

function formatAMPM(date) {
	  var hours = date.getHours();
	  var minutes = date.getMinutes();
	  var ampm = hours >= 12 ? 'pm' : 'am';
	  hours = hours % 12;
	  hours = hours ? hours : 12; // the hour '0' should be '12'
	  minutes = minutes < 10 ? '0'+minutes : minutes;
	  var strTime = hours + ':' + minutes + ' ' + ampm;
	  return date.getDate() + '/' + (date.getMonth() + 1) + '/' +  date.getFullYear() + ' ' + strTime;
	}