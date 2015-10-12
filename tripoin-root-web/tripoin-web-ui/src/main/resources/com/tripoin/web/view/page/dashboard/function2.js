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
				distance:-30,
				format : '<b>{point.name}</b>: {point.percentage:.1f} %',
				style : {
					color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
							|| 'black'
				}
	
			}
		}
	},
	series : [ {
		//name : '',
		colorByPoint : true,
//		data: [
//               ['New Customer Visit', 56.33],
//               ['Current', 16.1],
//               ['Non Active Customer', 14.2]
//           ],
//           dataLabels: {
//               enabled: true,
//               color: '#FFFFFF',
//               y: 10, // 10 pixels down from the top
//               style: {
//                   fontSize: '13px',
//                   fontFamily: 'Verdana, sans-serif'
//               }
//           }
		data : [ {
			name : 'New Customer Visit',
			y : 56.33
		}, {
			name : 'Current',
			y : 24.03,
			sliced : true,
			selected : true
		}, {
			name : 'Non Active Customer',
			y : 10.38
		} ]
	} ]
}