var options = {	// chart : {
	// plotBackgroundColor : null,
	// plotBorderWidth : null,
	// plotShadow : false,
	// type : 'pie'
	// },
	// title : {
	// text : 'Analisa pesanan'
	// },
	// subtitle : {
	// text : ''
	// },
	//
	// tooltip : {
	// pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
	// },
	// plotOptions : {
	// pie : {
	// allowPointSelect : true,
	// cursor : 'pointer',
	// size : '80%',
	// dataLabels : {
	// enabled : true,
	// distance:-30,
	// format : '<b>{point.name}</b>: {point.percentage:.1f} %',
	// style : {
	// color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
	// || 'black'
	// }
	//	
	// }
	// }
	// },
	// series : [ {
	// //name : '',
	// colorByPoint : true,
	// // data: [
	// // ['New Customer Visit', 56.33],
	// // ['Current', 16.1],
	// // ['Non Active Customer', 14.2]
	// // ],
	// // dataLabels: {
	// // enabled: true,
	// // color: '#FFFFFF',
	// // y: 10, // 10 pixels down from the top
	// // style: {
	// // fontSize: '13px',
	// // fontFamily: 'Verdana, sans-serif'
	// // }
	// // }
	// data : [ {
	// name : 'Order',
	// y : 56.33
	// }, {
	// name : 'Success',
	// y : 24.03,
	// sliced : true,
	// selected : true
	// }, {
	// name : 'Fail',
	// y : 10.38
	// } ]
	// } ]
		 chart: {
	            type: 'area'
	        },
	        title: {
	            text: 'Analisa Pemesanan',
	            x: -20 //center
	        },
	        subtitle: {
	            text: '',
	            x: -20
	        },
	        xAxis: {
	            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
	                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
	        },
	        yAxis: {
	            title: {
	                text: 'jumlah pesanan'
	            }
//	        ,
//	            plotLines: [{
//	                value: 0,
//	                width: 1,
//	                color: '#49ff00'
//	            },{
//	                value: 1,
//	                width: 1,
//	                color: '#ff0000'
//	            },{
//	                value: 2,
//	                width: 1,
//	                color: '#e3ff00'
//	            }]
	        },
	        tooltip: {
	            valueSuffix: '°C'
	        },
	        legend: {
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle',
	            borderWidth: 0
	        },
	        series: [{
	            name: 'Order',
//	            color: '#e3ff00',
	            data: [10, 15, 8,9, 17, 36, 10, 10, 20, 17, 18, 6]
	        },{
	            name: 'Success',
	            color: '#90ED7D',
	            data: [7, 8, 3, 5,10, 21, 6, 5, 11, 12, 9, 3]
	        }, {
	            name: 'Fail',
//	            color: '#ff0000',
	            color: '#434348',
	            data: [3,7, 5, 4, 7, 15, 4, 5, 9, 5, 9, 3]
	        } ]
}