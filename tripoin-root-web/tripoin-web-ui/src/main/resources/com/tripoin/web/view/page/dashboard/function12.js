var options = {
	chart : {
		plotBackgroundColor : null,
		plotBorderWidth : null,
		plotShadow : false,
		type : 'pie'
	},
	title : {
		text : 'Quotation Rate Analysis'
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
			name : 'Quote Hit Rate',
			y : 42
		}, {
			name : 'Lost Customer',
			y : 58,
			sliced : true,
			selected : true
		}]
	} ]
}