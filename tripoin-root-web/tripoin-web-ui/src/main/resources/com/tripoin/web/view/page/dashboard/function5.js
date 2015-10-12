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
			name : 'SAMARINDA',
			y : 39
		}, {
			name : 'BALIK PAPAN',
			y : 29,
			sliced : true,
			selected : true
		}, {
			name : 'BANJAR MASIN',
			y : 9
		}, {
			name : 'PALANGKARAYA',
			y : 13
		}, {
			name : 'PONTIANAK',
			y : 5
		}, {
			name : 'MAKASSAR',
			y : 3
		}, {
			name : 'MANADO',
			y : 2
		}]
	} ]
}