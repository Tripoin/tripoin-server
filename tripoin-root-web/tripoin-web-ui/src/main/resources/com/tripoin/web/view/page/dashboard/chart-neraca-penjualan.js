var options = {
		 title: {
	            text: 'Neraca penjualan',
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
	                text: 'jumlah pendapatan ($)'
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
	            name: 'Pendapatan',
	            color: '#49ff00',
	            data: [7, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
	        }, {
	            name: 'Pengeluaran',
	            color: '#ff0000',
	            data: [4, 8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
	        }, {
	            name: 'pendapatan bersih',
	            color: '#e3ff00',
	            data: [3, 6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
	        }]
    }