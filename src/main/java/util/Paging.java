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
			/*
			 * else sb.append("��");
			 */
		}

		return sb.toString();
	}
}