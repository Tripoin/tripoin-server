var options = {
	chart : {
		plotBackgroundColor : null,
		plotBorderWidth : null,
		plotShadow : false,
		type : 'pie'
	},
	title : {
		text : ''
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
			name : 'Coal Body',
			y : 21
		}, {
			name : 'Man Haul',
			y : 14
		}, {
			name : 'Crane',
			y : 16
		}, {
			name : 'Flat Bed',
			y : 9
		}, {
			name : 'Fuel & Lube Service',
			y : 13
		}, {
			name : 'Scow End',
			y : 24
		}, {
			name : '',
			y : 13
		}]
	} ]
}