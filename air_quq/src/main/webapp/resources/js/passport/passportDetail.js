let roadAddr = "";
let zipcode = "";


$("#searchDetail").click(function () {
   new daum.Postcode({
      oncomplete: function (data) {
         // console.log(data);
    	  roadAddr = data.roadAddress;
    	  zipcode = data.zonecode;
    	  $("#roadAddr").val(roadAddr);
    	  $("#zipcode").val(zipcode);
    	  $("#searchDetail").val(roadAddr);
    	  searchKeyword();
      },

      onsearch: function (data) {
//          console.log(roadAddr);
         $("#searchDetail").val(data.roadAddress);
      }
   }).open();
});


var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴


//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();


function searchKeyword(){
//주소로 좌표를 검색합니다
	geocoder.addressSearch(roadAddr, function(result, status) {
		
		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {
			
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
			console.log("위도 : " + result[0].y);
			console.log("경도 : " + result[0].x);
			
			$("input[name='lat']").val(result[0].y);
			$("input[name='lnt']").val(result[0].x);
			
			// 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});
			
			// 인포윈도우로 장소에 대한 설명을 표시합니다
			var infowindow = new kakao.maps.InfoWindow({
				content: '<div style="width:150px;text-align:center;padding:6px 0;">검색된 위치</div>'
			});
			infowindow.open(map, marker);
			
			// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			map.setCenter(coords);
		} 
	});   
	
}