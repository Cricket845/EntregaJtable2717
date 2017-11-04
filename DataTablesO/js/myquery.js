$(document).ready(function () {
	listar();
	listar2();
	listar3();
	listar4();
})

var listar=function () {
	var table=$("#tabla").DataTable({
		"ajax":{
		"method":"POST",
		"url":"selectusuario.php"
	},
	"columns":[
		{"data":"IdUsuario"},
		{"data":"Nombre"},
		{"data":"Correo"},
		{"data":"Telefono"}
	]
	});
}

var listar2=function () {
	var table2=$("#tabla2").DataTable({
		"ajax":{
		"method":"POST",
		"url":"selectinfo.php"
	},
	"columns":[
		{"data":"IdInfo"},
		{"data":"Edad"},
		{"data":"Direccion"}
	]
});
}


var listar3=function () {
var table3=$("#tabla3").DataTable({
	"ajax":{
	"method":"POST",
	"url":"selectdatos.php"
},
"columns":[
	{"data":"IdDatos"},
	{"data":"Carrera"},
	{"data":"Grupo"}
	
]
});
}

var listar4=function () {
var table4=$("#tabla4").DataTable({
	"ajax":{
	"method":"POST",
	"url":"selectmateria.php"
},
"columns":[
	{"data":"IdMateria"},
	{"data":"Materia"},
	{"data":"Profesor"}
]
});
}
