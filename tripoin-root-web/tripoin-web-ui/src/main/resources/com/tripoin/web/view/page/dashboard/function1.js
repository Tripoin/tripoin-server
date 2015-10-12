var options = {
        chart: {
            type: 'column'
        },
        title: {
            text: ''
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
                text: ''
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
            name: 'New Customer Visit',
            data: [49.9, 71.5, 106.4, 129.2, 144.0]

        }, {
            name: 'Current',
            data: [83.6, 78.8, 98.5, 93.4, 106.0]

        }, {
            name: 'Non Active Customer',
            data: [48.9, 38.8, 39.3, 41.4, 47.0]

        }]
    }