/*


grade

insert into grade values('1','�����');
insert into grade values('2','�ǹ�');
insert into grade values('3','���');
insert into grade values('4','�÷�Ƽ��');
insert into grade values('5','������');



 member

insert  into member values(seq_member_mem_idx.nextVal,5,'admin@campus.com','1234','����','�������Ӵ�','2022.07.07',sysdate,null,'�ݰ����ϴ�',1);
insert  into member values(seq_member_mem_idx.nextVal,3,'one@campus.com','1234','����','one�Ӵ�','2022.07.08',sysdate,null,'����մϴ�',1);
insert  into member values(seq_member_mem_idx.nextVal,4,'two@campus.com','1234','����','two�Ӵ�','2022.07.09',sysdate,null,'������',0);
insert  into member values(seq_member_mem_idx.nextVal,2,'three@campus.com','1234','����','three�Ӵ�','2022.07.10',sysdate,null,'�ߺ�Ź�帳�ϴ�',1);
insert  into member values(seq_member_mem_idx.nextVal,1,'four@campus.com','1234','����','four�Ӵ�','2022.07.10',sysdate,null,'������',1);

mem_out

insert into mem_out values(seq_mem_out_idx.nextVal,32,'2022.07.10');



 gradeup

insert into gradeup values(seq_gradeup_gradeup_idx.nextVal,2,5,1,10);
insert into gradeup values(seq_gradeup_gradeup_idx.nextVal,5,0,0,0);
insert into gradeup values(seq_gradeup_gradeup_idx.nextVal,4,3,1,3);

 msg

insert into msg values(seq_msg_msg_idx.nextVal,'�ȳ��ϼ���!�ֿ���',2,5,sysdate,null,'��������')

category

insert into grade values('1','����Խ���')
insert into grade values('2','�ŷ��Խ���')
insert into grade values('3','īǮ�Խ���')

review

insert into review values(seq_review_idx.nextVal,1,2,'ù��°����','ù��°������ó���','2022.07.07',26,3,null,'100.100.100.100')
insert into review values(seq_review_idx.nextVal,2,4,'�Ѱ� �������� �ٳ�Ծ��','�Ѱ�����ʹ�',sysdate,50,3,null,'100.100.100.100')
insert into review values(seq_review_idx.nextVal,3,5,'���õ�񳡳���..','�������','2022.07.09',40,1,null,'100.100.100.100')

 review_reply

insert into review_reply values(seq_review_reply_idx.nextVal,5,1,'�� ���־��',sysdate,'100.100.100.100')
insert into review_reply values(seq_review_reply_idx.nextVal,2,2,'���� �� �����߰ڳ׿�,,~',sysdate,'100.100.100.100')
insert into review_reply values(seq_review_reply_idx.nextVal,4,3,'wow',sysdate,'100.100.100.100')

review_like

insert into review_like values(seq_review_like_idx.nextVal,4,3,0)
insert into review_like values(seq_review_like_idx.nextVal,2,1,2)
insert into review_like values(seq_review_like_idx.nextVal,5,2,1)

review_reply_like
 
 insert into review_reply_like values(seq_review_reply_llike_idx.nextVal,4,3,0)
insert into review_reply_like values(seq_review_reply_llike_idx.nextVal,2,1,1)
insert into review_reply_like values(seq_review_reply_llike_idx.nextVal,5,2,0)

carpool

insert into carpool values(seq_carpool_idx.nextVal,2,2,'��簥���','�����ּ���','2022.07.07',2,0,'100.100.100.100')
insert into carpool values(seq_carpool_idx.nextVal,2,4,'8��15�� ���౸�ؿ�','��𰡽Ƿ���',sysdate,5,1,'100.100.100.100')
insert into carpool values(seq_carpool_idx.nextVal,2,5,'���ո� ���̰���','������','2022.07.01',16,3,'100.100.100.100')

carpool_reply

 insert into carpool_reply values(seq_carpool_reply_idx.nextVal,2,2,null,null,null)
insert into carpool_reply values(seq_carpool_reply_idx.nextVal,4,1,'����',sysdate,'100.100.100.100')
insert into carpool_reply values(seq_carpool_reply_idx.nextVal,5,3,'������Ⱦ��',sysdate,'100.100.100.100')

carpool_like

insert into carpool_like values(seq_carpool_like_idx.nextVal,5,3,1)
insert into carpool_like values(seq_carpool_like_idx.nextVal,2,1,0)
insert into carpool_like values(seq_carpool_like_idx.nextVal,4,2,1)

carpool_reply_like

insert into carpool_reply_like values(seq_carpool_reply_like_idx.nextVal,4,2,1)
insert into carpool_reply_like values(seq_carpool_reply_like_idx.nextVal,2,1,1)
insert into carpool_reply_like values(seq_carpool_reply_like_idx.nextVal,5,3,1)

market

insert into market values(seq_market_idx.nextVal,3,5,'���̽��ڽ� 15���� 500��','���̽��ڽ��� ���� 15�� ��µ� �ʹ� ��������',sysdate,25,20,null,'192.168.0.2','�˴ϴ�');
insert into market values(seq_market_idx.nextVal,3,4,'ķ������ ��ϴ�','ķ�����ڸ� �� ���;��',sysdate,17,119,null,'192.168.0.2','��ϴ�');
insert into market values(seq_market_idx.nextVal,3,1,'����縻 ���ᳪ���մϴ�','3�� ����� ����縻 ���ᳪ���մϴ�',sysdate,64,81,null,'192.168.0.2','����');


market_reply

insert into market_reply values(seq_market_Reply_idx.nextVal,2,1,'���̽��ڽ� ���� ��ϴ�',sysdate,'192.168.3.7');
insert into market_reply values(seq_market_Reply_idx.nextVal,1,2,'ķ������ �� ��ñ� �ٶ��ϴ�',sysdate,'192.168.3.7');
insert into market_reply values(seq_market_Reply_idx.nextVal,3,3,'����縻 ������ ���� ���� �ɱ?',sysdate,'192.168.3.7');

market_like

insert into market_like values(seq_market_like_idx.nextVal,1,1,1);
insert into market_like values(seq_market_like_idx.nextVal,2,2,1);
insert into market_like values(seq_market_like_idx.nextVal,3,3,1);

market_reply_like

insert into market_reply_like values(seq_market_reply_like_idx.nextVal,1,1,1);
insert into market_reply_like values(seq_market_reply_like_idx.nextVal,2,1,1);
insert into market_reply_like values(seq_market_reply_like_idx.nextVal,3,1,1);




































*/