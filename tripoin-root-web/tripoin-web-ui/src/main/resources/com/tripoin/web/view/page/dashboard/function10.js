var options = {
		chart: {
            type: 'column',
            options3d: {
                enabled: true,
                alpha: 15,
                beta: 15,
                viewDistance: 25,
                depth: 40
            },
            marginTop: 80,
            marginRight: 40
        },

        title: {
            text: 'PP Market Share(CBUEuropean Category V)'
        },

        xAxis: {
            categories: ['Apples', 'Oranges', 'Pears', 'Grapes', 'Bananas']
        },

        yAxis: {
            allowDecimals: false,
            min: 0,
            title: {
                text: ''
            }
        },

        tooltip: {
            headerFormat: '<b>{point.key}</b><br>',
            pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y} / {point.stackTotal}'
        },

        plotOptions: {
            column: {
                stacking: 'normal',
                depth: 40
            }
        },

        series: [{
            name: 'Volvo',
            data: [22,16,28,23],
            stack: 'years'
        }, {
            name: 'Renault',
            data: [5,6,9,5],
            stack: 'years'
        }, {
            name: 'MB',
            data: [15,20,31,32],
            stack: 'years'
        }, {
            name: 'MAN',
            data: [16,21,3,5],
            stack: 'years'
        }, {
            name: 'Iveco',
            data: [10,8,11,9],
            stack: 'years'
        }, {
            name: 'Scania',
            data: [32,28,18,27],
            stack: 'years'
        }]
}