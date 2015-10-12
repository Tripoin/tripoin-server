var options = {
	chart : {
		type : 'pie',
			options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
	},
	title : {
		text : 'CUSTOMER SEGMENT'
	},
	subtitle : {
		text : ''
	},

	tooltip : {
		pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
	},
	plotOptions : {
		pie : {
			allowPointSelect : true,
			cursor : 'pointer',
			size : '80%',
			depth: 35,
			dataLabels : {
				enabled : true,
				format : '<b>{point.name}</b>: {point.percentage:.1f} %',
				style : {
					color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
							|| 'black'
				}
			}
		}
	},
	series : [ {

		colorByPoint : true,
		data : [ {
			name : 'Mining',
			y : 72
		}, {
			name : 'Fabricator',
			y : 9,
			sliced : true,
			selected : true
		}, {
			name : 'Others',
			y : 9
		}, {
			name : 'Oil And Gas',
			y : 13
		}]
	} ]
}