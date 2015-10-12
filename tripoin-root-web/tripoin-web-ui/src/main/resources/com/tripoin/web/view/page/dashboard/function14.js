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
                pointPadding: 0.0,
                borderWidth: 0
            }
        },
        series: [{
            name: 'Mining',
            data: [49.9, 71.5, 106.4, 129.2, 144.0]

        }, {
            name: 'Oil & Gas',
            data: [83.6, 78.8, 98.5, 93.4, 106.0]

        }, {
            name: 'Agriculture & Foresty',
            data: [48.9, 38.8, 39.3, 41.4, 47.0]

        }, {
            name: 'On Road Logistic',
            data: [83.6, 78.8, 98.5, 93.4, 106.0]

        },{
            name: 'Monicipal',
            data: [49.9, 71.5, 106.4, 129.2, 144.0]

        }]
    }