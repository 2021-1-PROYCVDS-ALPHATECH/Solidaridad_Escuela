<script type="text/javascript">
    $(document).ready(function () {
        $("#grid").shieldGrid({
            dataSource: {
                data: gridData
            },
            paging: {
                pageSize: 20,
                pageLinksCount: 10
            },
            columns: [
                { field: "id", width: "70px", title: "ID" },
                { field: "name", title: "Person Name" },
                { field: "company", title: "Company Name" },
                { field: "email", title: "Email Address", width: "270px" }
            ],
            toolbar: [
                {
                    buttons: [
                        {
                            commandName: "pdf",
                            caption: '<span class="sui-sprite sui-grid-icon-export-pdf"></span> <span class="sui-grid-button-text">Export to PDF</span>'
                        }
                    ]
                }
            ],
            exportOptions: {
                proxy: "/filesaver/save",
                pdf: {
                    fileName: "shieldui-export",
                    author: "John Smith",
                    dataSource: {
                        data: gridData
                    },
                    readDataSource: true,
                    header: {
                        cells: [
                            { field: "id", title: "ID", width: 50 },
                            { field: "name", title: "Person Name", width: 100 },
                            { field: "company", title: "Company Name", width: 100 },
                            { field: "email", title: "Email Address" }
                        ]
                    }
                }
            }
        })
    });
</script>