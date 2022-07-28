package util;

public class Paging {											  
	public static String getPaging(String pageURL,
			
								   int nowPage, 
								   int rowTotal,
								   int blockList, 
								   int blockPage) {
		
		int totalPage,
            startPage = 0,
            endPage;

		boolean  isPrevPage,isNextPage;
		StringBuffer sb; 
		
		isPrevPage=isNextPage=false;
		totalPage = rowTotal/blockList; 
		
		if(rowTotal%blockList!=0)totalPage++;
		

		if(nowPage > totalPage)nowPage = totalPage;
		
		if(startPage>0) {
		
			startPage = ((nowPage-1)/blockPage)*blockPage+1;
		
		} else if (startPage<=0) {
			
			startPage = 1;
		}
		
			endPage = startPage + blockPage - 1; //
			
			
			if(endPage > totalPage)endPage = totalPage;
			if(endPage < totalPage) isNextPage = true;
			if(startPage > 1)isPrevPage = true;
		
		
		sb = new StringBuffer();

//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------	
	
	
			if(isPrevPage){
					sb.append("<a href ='"+pageURL+"?page=");
					sb.append(startPage-1); //����׷캸�� �����׷��� ���������������̵�
					sb.append("'></a>");
					
				} else {
					
					isPrevPage = false;
				}


//------������ ��� ��� -------------------------------------------------------------------------------------------------

		for(int i=startPage; i<= endPage ;i++){
			
			if(i>totalPage)break;
			if(i<startPage)break;
			
			if(i == nowPage){ //���� �ִ� ������
				sb.append("&nbsp;<a href='"+pageURL+"?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
			else{//���� �������� �ƴϸ�
				sb.append("&nbsp;<a href='"+pageURL+"?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}// end for
		
		
//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
		for(int i=startPage; i<= endPage ;i++){
			
			if(isNextPage){
				sb.append("<a href ='"+pageURL+"?page=");
				sb.append(endPage+1);
				sb.append("'></a>");
			}
			
		
		}

		return sb.toString();
	}
	
	
//----------------------------------------------------------------------	
//�˻�����߰�
public static String getPaging(String pageURL,
							   String search_filter, 
							   int nowPage, 
							   int rowTotal, 
							   int blockList,
							   int blockPage) {
		int totalPage;
		int startPage = 0;
		int endPage;
		
		int zzinstartPage = 1;
		

	boolean  isPrevPage,isNextPage;
	boolean  PrevPage,NextPage;
	StringBuffer sb; 
	
	isPrevPage=isNextPage=false;
	PrevPage=NextPage=false;
	
	totalPage = rowTotal/blockList; 
	
	if(rowTotal%blockList!=0)totalPage++;
	

	if(nowPage > totalPage)nowPage = totalPage;
	

		startPage = ((nowPage-1)/blockPage)*blockPage+1;
		endPage = startPage + blockPage - 1; //
		
		
		if(endPage > totalPage)endPage = totalPage;
		if(endPage < totalPage) isNextPage = true;
		if(startPage <= totalPage )isPrevPage = true;
		
		if(nowPage < totalPage) NextPage = true;
		if(nowPage > zzinstartPage)PrevPage = true;
		
	
	
	sb = new StringBuffer();

//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------	


		if(isPrevPage){
				sb.append("<a class='first' href ='"+pageURL+"?page=1");
				sb.append("&");
				sb.append(search_filter);
				sb.append("'></a>");
				
				
			} else {
				
				sb.append("<a class='first'></a>");
				//sb.append("<a class='prev' href ='"+pageURL+"?page=");
			
			}

		if(PrevPage){
			sb.append("<a class='prev' href ='"+pageURL+"?page=");
			sb.append(nowPage-1); //����׷캸�� �����׷��� ���������������̵�
			sb.append("&");
			sb.append(search_filter);
			sb.append("'></a>");
			
			
			
		} else {
			
			sb.append("<a class='prev'></a>");
			//sb.append("<a class='prev' href ='"+pageURL+"?page=");
			
		}
		

	
//------������ ��� ��� -------------------------------------------------------------------------------------------------

	for(int i=startPage; i<= endPage ;i++){
		
		if(i>totalPage)break;
		if(i<startPage)break;
		
		if(i == nowPage){ //���� �ִ� ������
			sb.append("&nbsp;<b><a href='"+pageURL+"?page=");
			sb.append(i);
			sb.append("'>");
			sb.append(i);
			sb.append("</a></b>");
		}
		else{//���� �������� �ƴϸ�
			sb.append("&nbsp;<a href='"+pageURL+"?page=");
			sb.append(i);
			sb.append("&");
			sb.append(search_filter);
			sb.append("'>");
			sb.append(i);
			sb.append("</a>");
		}
	}// end for
	
	
//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
	
	if(NextPage){
		sb.append("<a  class='next' href ='"+pageURL+"?page=");
		sb.append(nowPage+1);
		sb.append("&");
		sb.append(search_filter);
		sb.append("'></a>");
	}else {
		sb.append("<a class='next'></a>");
	}
	
		
	if(isNextPage){
		sb.append("<a  class='last' href ='"+pageURL+"?page=");
		sb.append(endPage+1);
		sb.append("&");
		sb.append(search_filter);
		sb.append("'></a>");
	}else {
		sb.append("<a class='last'></a>");
	}
	
	
	

	return sb.toString();
  }





//��� ����¡----------------------------------------------------------------------------------
		public static String review_commentPaging(String pageURL,
				   int nowPage, 
				   int rowTotal, 
				   int blockList,
				   int blockPage,
				   int view_idx) {
		int totalPage;
		int startPage = 0;
		int endPage;
		
		int zzinstartPage = 1;
		
		
		boolean  isPrevPage,isNextPage;
		boolean  PrevPage,NextPage;
		StringBuffer sb; 
		
		isPrevPage=isNextPage=false;
		PrevPage=NextPage=false;
		
		totalPage = rowTotal/blockList; 
		
		if(rowTotal%blockList!=0)totalPage++;
		
		
		if(nowPage > totalPage)nowPage = totalPage;
		
		
		startPage = ((nowPage-1)/blockPage)*blockPage+1;
		endPage = startPage + blockPage - 1; //
		
		
		if(endPage > totalPage)endPage = totalPage;
		if(endPage < totalPage) isNextPage = true;
		if(startPage <= totalPage )isPrevPage = true;
		
		if(nowPage < totalPage) NextPage = true;
		if(nowPage > zzinstartPage)PrevPage = true;
		
		
		
		sb = new StringBuffer();
		
		//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------	
		
		
		if(isPrevPage){
		sb.append("<a class='first' href ='"+pageURL+"?page=1");
		sb.append("&");
		sb.append("review_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		
		
		} else {
		
		sb.append("<a class='first'></a>");
		//sb.append("<a class='prev' href ='"+pageURL+"?page=");
		
		}
		
		if(PrevPage){
		sb.append("<a class='prev' href ='"+pageURL+"?page=");
		sb.append(nowPage-1); //����׷캸�� �����׷��� ���������������̵�
		sb.append("&");
		sb.append("review_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		
		
		
		} else {
		
		sb.append("<a class='prev'></a>");
		//sb.append("<a class='prev' href ='"+pageURL+"?page=");
		
		}
		
		
		
		//------������ ��� ��� -------------------------------------------------------------------------------------------------
		
		for(int i=startPage; i<= endPage ;i++){
		
		if(i>totalPage)break;
		if(i<startPage)break;
		
		if(i == nowPage){ //���� �ִ� ������
			sb.append("&nbsp;<b><a href='"+pageURL+"?page=");
			sb.append(i);
			sb.append("'>");
			sb.append(i);
			sb.append("</a></b>");
		}
		else{//���� �������� �ƴϸ�
		sb.append("&nbsp;<a href='"+pageURL+"?page=");
		sb.append(i);
		sb.append("&");
		sb.append("review_idx=");
		sb.append(view_idx);
		sb.append("'>");
		sb.append(i);
		sb.append("</a>");
		}
		}// end for
		
		
		//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
		
		if(NextPage){
		sb.append("<a  class='next' href ='"+pageURL+"?page=");
		sb.append(nowPage+1);
		sb.append("&");
		sb.append("review_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		}else {
		sb.append("<a class='next'></a>");
		}
		
		
		if(isNextPage){
		sb.append("<a  class='last' href ='"+pageURL+"?page=");
		sb.append(endPage+1);
		sb.append("&");
		sb.append("review_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		}else {
		sb.append("<a class='last'></a>");
		}
		
		
		
		
		return sb.toString();
		}
		
		public static String carpool_commentPaging(String pageURL,
				   int nowPage, 
				   int rowTotal, 
				   int blockList,
				   int blockPage,
				   int view_idx) {
		int totalPage;
		int startPage = 0;
		int endPage;
		
		int zzinstartPage = 1;
		
		
		boolean  isPrevPage,isNextPage;
		boolean  PrevPage,NextPage;
		StringBuffer sb; 
		
		isPrevPage=isNextPage=false;
		PrevPage=NextPage=false;
		
		totalPage = rowTotal/blockList; 
		
		if(rowTotal%blockList!=0)totalPage++;
		
		
		if(nowPage > totalPage)nowPage = totalPage;
		
		
		startPage = ((nowPage-1)/blockPage)*blockPage+1;
		endPage = startPage + blockPage - 1; //
		
		
		if(endPage > totalPage)endPage = totalPage;
		if(endPage < totalPage) isNextPage = true;
		if(startPage <= totalPage )isPrevPage = true;
		
		if(nowPage < totalPage) NextPage = true;
		if(nowPage > zzinstartPage)PrevPage = true;
		
		
		
		sb = new StringBuffer();
		
		//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------	
		
		
		if(isPrevPage){
		sb.append("<a class='first' href ='"+pageURL+"?page=1");
		sb.append("&");
		sb.append("carpool_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		
		
		} else {
		
		sb.append("<a class='first'></a>");
		//sb.append("<a class='prev' href ='"+pageURL+"?page=");
		
		}
		
		if(PrevPage){
		sb.append("<a class='prev' href ='"+pageURL+"?page=");
		sb.append(nowPage-1); //����׷캸�� �����׷��� ���������������̵�
		sb.append("&");
		sb.append("carpool_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		
		
		
		} else {
		
		sb.append("<a class='prev'></a>");
		//sb.append("<a class='prev' href ='"+pageURL+"?page=");
		
		}
		
		
		
		//------������ ��� ��� -------------------------------------------------------------------------------------------------
		
		for(int i=startPage; i<= endPage ;i++){
		
		if(i>totalPage)break;
		if(i<startPage)break;
		
		if(i == nowPage){ //���� �ִ� ������
			sb.append("&nbsp;<b><a href='"+pageURL+"?page=");
			sb.append(i);
			sb.append("'>");
			sb.append(i);
			sb.append("</a></b>");
		}
		else{//���� �������� �ƴϸ�
		sb.append("&nbsp;<a href='"+pageURL+"?page=");
		sb.append(i);
		sb.append("&");
		sb.append("carpool_idx=");
		sb.append(view_idx);
		sb.append("'>");
		sb.append(i);
		sb.append("</a>");
		}
		}// end for
		
		
		//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
		
		if(NextPage){
		sb.append("<a  class='next' href ='"+pageURL+"?page=");
		sb.append(nowPage+1);
		sb.append("&");
		sb.append("carpool_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		}else {
		sb.append("<a class='next'></a>");
		}
		
		
		if(isNextPage){
		sb.append("<a  class='last' href ='"+pageURL+"?page=");
		sb.append(endPage+1);
		sb.append("&");
		sb.append("carpool_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		}else {
		sb.append("<a class='last'></a>");
		}
		
		
		
		
		return sb.toString();
		}
		
		public static String market_commentPaging(String pageURL,
				   int nowPage, 
				   int rowTotal, 
				   int blockList,
				   int blockPage,
				   int view_idx) {
		int totalPage;
		int startPage = 0;
		int endPage;
		
		int zzinstartPage = 1;
		
		
		boolean  isPrevPage,isNextPage;
		boolean  PrevPage,NextPage;
		StringBuffer sb; 
		
		isPrevPage=isNextPage=false;
		PrevPage=NextPage=false;
		
		totalPage = rowTotal/blockList; 
		
		if(rowTotal%blockList!=0)totalPage++;
		
		
		if(nowPage > totalPage)nowPage = totalPage;
		
		
		startPage = ((nowPage-1)/blockPage)*blockPage+1;
		endPage = startPage + blockPage - 1; //
		
		
		if(endPage > totalPage)endPage = totalPage;
		if(endPage < totalPage) isNextPage = true;
		if(startPage <= totalPage )isPrevPage = true;
		
		if(nowPage < totalPage) NextPage = true;
		if(nowPage > zzinstartPage)PrevPage = true;
		
		
		
		sb = new StringBuffer();
		
		//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------	
		
		
		if(isPrevPage){
		sb.append("<a class='first' href ='"+pageURL+"?page=1");
		sb.append("&");
		sb.append("market_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		
		
		} else {
		
		sb.append("<a class='first'></a>");
		//sb.append("<a class='prev' href ='"+pageURL+"?page=");
		
		}
		
		if(PrevPage){
		sb.append("<a class='prev' href ='"+pageURL+"?page=");
		sb.append(nowPage-1); //����׷캸�� �����׷��� ���������������̵�
		sb.append("&");
		sb.append("market_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		
		
		
		} else {
		
		sb.append("<a class='prev'></a>");
		//sb.append("<a class='prev' href ='"+pageURL+"?page=");
		
		}
		
		
		
		//------������ ��� ��� -------------------------------------------------------------------------------------------------
		
		for(int i=startPage; i<= endPage ;i++){
		
		if(i>totalPage)break;
		if(i<startPage)break;
		
		if(i == nowPage){ //���� �ִ� ������
			sb.append("&nbsp;<b><a href='"+pageURL+"?page=");
			sb.append(i);
			sb.append("'>");
			sb.append(i);
			sb.append("</a></b>");
		}
		else{//���� �������� �ƴϸ�
		sb.append("&nbsp;<a href='"+pageURL+"?page=");
		sb.append(i);
		sb.append("&");
		sb.append("market_idx=");
		sb.append(view_idx);
		sb.append("'>");
		sb.append(i);
		sb.append("</a>");
		}
		}// end for
		
		
		//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
		
		if(NextPage){
		sb.append("<a  class='next' href ='"+pageURL+"?page=");
		sb.append(nowPage+1);
		sb.append("&");
		sb.append("market_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		}else {
		sb.append("<a class='next'></a>");
		}
		
		
		if(isNextPage){
		sb.append("<a  class='last' href ='"+pageURL+"?page=");
		sb.append(endPage+1);
		sb.append("&");
		sb.append("market_idx=");
		sb.append(view_idx);
		sb.append("'></a>");
		}else {
		sb.append("<a class='last'></a>");
		}
		
		
		
		
		return sb.toString();
		}



}