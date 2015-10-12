var options = {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Analisa produk'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                'W1',
                'W2',
                'W3',
                'W4',
                'W5'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'jumlah produk'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'Total Produk',
            data: [60, 80,75, 50, 90]

        }, {
            name: 'Produk Terjual',
            data: [40, 40, 35, 30, 50]

        }, {
            name: 'Produk Belum Terjual',
            data: [20, 40, 40, 20, 40]

        }]
    }