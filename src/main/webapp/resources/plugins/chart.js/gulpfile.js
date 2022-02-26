var gulp = require('gulp'),
	concat = require('gulp-concat'),
	uglify = require('gulp-uglify'),
	util = require('gulp-util'),
	jshint = require('gulp-jshint'),
	size = require('gulp-size'),
	connect = require('gulp-connect'),
	replace = require('gulp-replace'),
	htmlv = require('gulp-html-validator'),
	inquirer = require('inquirer'),
	semver = require('semver'),
	exec = require('child_process').exec,
	fs = require('fs'),
	package = require('./package.json'),
	bower = require('./bower.json');

var srcDir = './src/';
/*
 *	Usage : gulp build --types=Bar,Line,Doughnut
 *	Output: - A built Chart.js file with Core and types Bar, Line and Doughnut concatenated together
 *			- A minified version of this code, in Chart.min.js
 */

gulp.task('build', function(){

	// Default to all of the chart types, with Chart.Core first
	var srcFiles = [FileName('Core')],
		isCustom = !!(util.env.types),
		outputDir = (isCustom) ? 'custom' : '.';
	if (isCustom){
		util.env.types.split(',').forEach(function(type){ return srcFiles.push(FileName(type))});
	}
	else{
		// Seems gulp-concat remove duplicates - nice!
		// So we can use this to sort out dependency order - aka include Core first!
		srcFiles.push(srcDir+'*');
	}

	
gulp.task('jshint', function(){
	return gulp.src(srcDir + '*.js')
		.pipe(jshint())
		.pipe(jshint.reporter('default'));
});

gulp.task('valid', function(){
	return gulp.src('samples/*.html')
    .pipe(htmlv());
});

gulp.task('library-size', function(){
	return gulp.src('Chart.min.js')
		.pipe(size({
			gzip: true
		}));
});

gulp.task('module-sizes', function(){
	return gulp.src(srcDir + '*.js')
	.pipe(uglify({preserveComments:'some'}))
	.pipe(size({
		showFiles: true,
		gzip: true
	}))
});

gulp.task('watch', function(){
	gulp.watch('./src/*', ['build']);
});

gulp.task('test', ['jshint', 'valid']);

gulp.task('size', ['library-size', 'module-sizes']);

gulp.task('default', ['build', 'watch']);

gulp.task('server', function(){
	connect.server({
		port: 8000
	});
});


