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
			name : 'JAKARTA',
			y : 44
		}, {
			name : 'CIKAMPEK',
			y : 22,
			sliced : true,
			selected : true
		}, {
			name : 'PALEMBANG',
			y : 11
		}, {
			name : 'RIAU',
			y : 6
		}, {
			name : 'PEKAN BARU',
			y : 4
		}, {
			name : 'JAMBI',
			y : 7
		}, {
			name : 'LAMPUNG',
			y : 6
		} ]
	} ]
}