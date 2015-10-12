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
			distance:-30,
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
			name : 'Iveco',
			y : 12
		}, {
			name : 'Lost Reported',
			y : 29,
			sliced : true,
			selected : true
		}, {
			name : 'Lost Not Reported',
			y : 59
		}]
	} ]
}