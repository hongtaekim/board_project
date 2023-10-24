/**
 * 페이지 뒤로가기 눌렀을때 자동으로 리프레시
 */
 window.onpageshow = function(e){
	if(e.persisted){
		document.location.reload();
	}
}