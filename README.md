# Laundry
Project Website management laundry dibuat untuk melatih mengoding dengan bahasa pemograman java
dengan framework spring boot, tampilan menggunakan java server page (JSP) dan database
menggunakan PostgreSQL
Berikut menu dan fungsional yang telah selesai dibuat :
Menu master data  -> Sub menu “master data price list dan outlet laundry” dengan method create read dan update untuk melengkapi data management laundry
Menu transaksi    -> Sub menu “Input Order” untuk create data pelanggan
                  -> Sub menu “Lihat Order” yaitu list semua order dengan berbagai status
                      * Jika status in order maka muncul button “Tambah Item” yaitu untuk menambahkan item yang akan di laundry : Memilih list laundry dan                         input berat / satuan lalu klik button “tambah” maka datanya pindah ke kolom dibawah dan “simpan” jika sudah sesuai, maka status                             menjadi Process Order
                      * Jika status Process Order maka muncul button “Selesai Pencucian” yaitu untuk merubah status menjadi Done Order
                      * Jika status Done Order maka muncul button “Bayar” yaitu untuk memunculkan form pembayaran : Masukan uang customer, total kembalian                         akan muncul lalu klik bayar Maka status paid dan button menjadi “Kwitansi”
                  -> Sub menu “Lihat Lokasi” untuk melihat lokasi outlet sesuai titik kordinat
                      
