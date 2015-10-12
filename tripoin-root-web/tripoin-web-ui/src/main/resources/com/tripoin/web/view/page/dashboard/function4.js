var options = {
		chart: {
            type: 'column'
        },
        title: {
            text: ''
        },
        xAxis: {
            categories: ['Jan',
                'Feb',
                'Mar',
                'Apr',
                'May',
                'Jun',
                'Jul',
                'Aug',
                'Sep',
                'Oct',
                'Nov',
                'Dec']
        },
        yAxis: {
            min: 0,
            title: {
                text: ''
            },
            stackLabels: {
                enabled: true,
                style: {
                    fontWeight: 'bold',
                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                }
            }
        },
        legend: {
            align: 'right',
            x: -30,
            verticalAlign: 'top',
            y: 25,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.x + '</b><br/>' +
                    this.series.name + ': ' + this.y + '<br/>' +
                    'Total: ' + this.point.stackTotal;
            }
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                    style: {
                        textShadow: '0 0 3px black'
                    }
                }
            }
        },
        series: [{
            name: '4x2',
            data: [0,0,0,0,0,0,0,0,1,0,0,0]
        }, {
            name: '4x4',
            data: [3,1,0,1,4,2,0,1,0,4,13,15]
        }, {
            name: '6x2',
             data: [0,0,0,0,0,0,0,0,0,1,0,0]
        }, {
            name: '6x4',
             data: [0,0,0,2,3,9,7,3,1,5,0,3]
        }, {
            name: '6x6',
             data: [1,2,2,2,1,4,9,1,2,1,0,3]
        }, {
            name: '8x4',
            data: [0,0,0,5,2,1,10,10,0,0,0,1]
        }]
    }