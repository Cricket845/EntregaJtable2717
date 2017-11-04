<html>
    <head>
        <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <link href="${pageContext.request.contextPath}/js/jtable.2.3.1/themes/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
        <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.jtable.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.hotkeys-0.7.9.min.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/js/validationEngine/validationEngine.jquery.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/validationEngine/jquery.validationEngine.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/validationEngine/jquery.validationEngine-es.js"></script>
    </head>
    <body>

        <div id="Usuarios" style="margin:auto;width:95%;">
            <div align="lefth"> <input  type="button" value="Eliminar Registros" id="DeleteAllButton"/></div>
                     <form action="pdf">
            <input type="submit" value="Crear PDF">
        </form>
        </div>
        <!-- <form action="pdf">
            <input type="submit" value="Crear PDF">
        </form>-->
        <script type="text/javascript">
            $(document).ready(function () {
                $('#Usuarios').jtable({
                    title: 'Gestion de Representacion Periodistica',
                    paging: true,
                    pageSize: 10,
                    sorting: true,
                    defaultSorting: 'Nombre ASC',
                    selecting: true,
                    multiselect: true,
                    selectingCheckboxes: true,
                    toolbarsearch: false,
                    actions: {
                        listAction:   '${pageContext.request.contextPath}/Control?action=list',
                        createAction: '${pageContext.request.contextPath}/Control?action=create',
                        updateAction: '${pageContext.request.contextPath}/Control?action=update',
                        deleteAction: '${pageContext.request.contextPath}/Control?action=delete'
                    },
                    fields: {
                        IdUsuario: {
                            key: true,
                            create: false,
                            edit: false,
                            list: false
                        },
                        Usuario: {
                            title: 'Usuario '
                        },
                        Password: {
                            title: 'Password'
                        },
                        Nombre: {
                            title: 'Nombre'
                        },
                        periodico: {
                            title: '',
                            width: '5%',
                            sorting: true,
                            edit: false,
                            create: false,
                            display: function (studentData) {
                                var $img = $('<img src="menu.png" title="Editar Periodicos" />');
                                $img.click(function () {
                                    $('#Usuarios').jtable('openChildTable',
                                            $img.closest('tr'),
                                            {
                                                title: 'Periodico representado por ' + studentData.record.Nombre,
                                                actions: {
                                                    listAction: '${pageContext.request.contextPath}/ControlP?action=list&IdUsuario=' + studentData.record.IdUsuario,
                                                    createAction: '${pageContext.request.contextPath}/ControlP?action=create&IdUsuario='+ studentData.record.IdUsuario,
                                                    updateAction: '${pageContext.request.contextPath}/ControlP?action=update&IdUsuario='+ studentData.record.IdUsuario,
                                                    deleteAction: '${pageContext.request.contextPath}/ControlP?action=delete&IdUsuario='+ studentData.record.IdUsuario
                                                },
                                                fields: {
                                                    IdUsuario: {
                                                        type: 'hidden',
                                                        defaultValue: studentData.record.IdUsuario
                                                    },
                                                    IdPeriodico: {
                                                        key: true,
                                                        create: false,
                                                        edit: false,
                                                        list: false
                                                    },
                                                    Nombre: {
                                                        title: 'Nombre '
                                                    },
                                                    Estado: {
                                                        title: 'Estado '
                                                    },
                                                    Tipo: {
                                                        title: 'Tipo '
                                                    },
                                                    Precio: {
                                                        title: 'Precio '
                                                    }

                                                }

                                            }, function (data) { //opened handler
                                        data.childTable.jtable('load');

                                    });
                                });

                                return $img;
                            }
                        },
                         agencia: {
                            title: '',
                            width: '5%',
                            sorting: true,
                            edit: false,
                            create: false,
                            display: function (studentData) {
                                var $img = $('<img src="menu.png" title="Editar Agencia" />');
                                $img.click(function () {
                                    $('#Usuarios').jtable('openChildTable',
                                            $img.closest('tr'),
                                            {
                                                title: 'Lista de Agencias por Representante' +studentData.record.Nombre,
                                                actions: {
                                                    listAction: '${pageContext.request.contextPath}/ControlA?action=list&IdUsuario=' + studentData.record.IdUsuario,
                                                    createAction: '${pageContext.request.contextPath}/ControlA?action=create&IdUsuario='+ studentData.record.IdUsuario,
                                                    updateAction: '${pageContext.request.contextPath}/ControlA?action=update&IdUsuario='+ studentData.record.IdUsuario,
                                                    deleteAction: '${pageContext.request.contextPath}/ControlA?action=delete&IdUsuario='+ studentData.record.IdUsuario
                                                },
                                                fields: {
                                                    IdUsuario: {
                                                        type: 'hidden',
                                                        defaultValue: studentData.record.IdUsuario
                                                    },
                                                    IdAgencia: {
                                                        key: true,
                                                        create: false,
                                                        edit: false,
                                                        list: false
                                                    },
                                                    Nombre: {
                                                        title: 'Nombre '
                                                    },
                                                    Estado: {
                                                        title: 'Estado '
                                                    },
                                                    Direccion: {
                                                        title: 'Direccion '
                                                    },
                                                    Telefono: {
                                                        title: 'Telefono '
                                                    }

                                                }

                                            }, function (data) { //opened handler
                                        data.childTable.jtable('load');

                                    });
                                });

                                return $img;
                            }
                        }

                    }
                });
                $('#Usuarios').jtable('load');
            });
            $('#DeleteAllButton').button().click(function () {
                var $selectedRows = $('#Usuarios').jtable('selectedRows');
                $('#Usuarios').jtable('deleteRows', $selectedRows);
            });
        </script>

    </body>
</html>
