package Util;
import java.text.SimpleDateFormat;
import java.util.*;
  //Dateutil.today()
//  Dateutil.util2sql(); Dateutil.String_oneday(0);
public class Dateutil {
		public   static String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_NOW);
		static long millisecondsOfOneDay = 1000*60*60*24;  
	  
	    public static java.sql.Date util2sql(java.util.Date d){
	        return  new java.sql.Date(d.getTime());
	    }
	    public static java.util.Date  util2sql(java.sql.Date d){
	        return  new java.util.Date(d.getTime());
	    }
	    public static String DatetoString(Date date) {
	    	return simpleDateFormat.format(date);
	    } 
	    /**
	     * ��ȡ���죬���Ұ�ʱ���֣���ͺ��붼��0. ��Ϊͨ�����ڿؼ���ȡ�������ڣ�����û��ʱ����ͺ���ġ�
	     * @return
	     */
	    public static Date today(){
	        Calendar c = Calendar.getInstance();
	        c.setTime(new Date());
	        c.set(Calendar.HOUR, 0);
	        c.set(Calendar.MINUTE, 0);
	        c.set(Calendar.SECOND, 0);
	        return c.getTime();
	          
	    }
	    public static Date oneday(int dif){//���һ����ʽΪ"Sat Feb 29 10:50:57 CST 2020"�ĵ�ǰʱ���ʽ
	        Calendar c = Calendar.getInstance();
	        c.setTime(new Date());
	        c.add(Calendar.DATE, dif);//��ǰ
//	        c.set(Calendar.HOUR, 0);
//	        c.set(Calendar.MINUTE, 0);
//	        c.set(Calendar.SECOND, 0);
	        return c.getTime();
	          
	    }
	    public static String String_oneday(int dif){//��һ����ʽΪ"Sat Feb 29 10:50:57 CST 2020"�ĵ�ǰʱ���ʽ
	        Calendar c = Calendar.getInstance();
	        c.setTime(new Date());
	        c.add(Calendar.DATE, dif);//��ǰ
//	        c.set(Calendar.HOUR, 0);
//	        c.set(Calendar.MINUTE, 0);
//	        c.set(Calendar.SECOND, 0);
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_NOW);  
	        String Date11 = simpleDateFormat.format(c.getTime());
	        return Date11;
	          
	    }
	    /**
	     * ��ȡ�³���ʹ��Calendar��ȡ���µ�һ�졣 ��ͳ������һ����Ϣ��ʱ�򣬲鿴���µ��������ݣ���ʵ���Ǵ����ݿ���ȥ�Ѵӱ��µ�һ�쵽���һ������ݲ�������ٽ��м�ͳ�ƣ�������Ҫһ����ȡ���µ�һ��ķ�����
	     * @return
	     */
	  
	    public static Date monthBegin() {
	        Calendar c = Calendar.getInstance();
	        c.setTime(new Date());
	        c.set(Calendar.DATE, 1);
	          
	        c.set(Calendar.HOUR_OF_DAY, 0);
	        c.set(Calendar.MINUTE, 0);
	        c.set(Calendar.SECOND, 0);
	        c.set(Calendar.MILLISECOND, 0);
	          
	        return c.getTime();
	    }
	      
	    /**
	     * ��ȡ��ĩ
	     * @return
	     */
	    public static Date monthEnd() {
	        Calendar c = Calendar.getInstance();
	        c.setTime(new Date());
	        c.set(Calendar.HOUR, 0);
	        c.set(Calendar.MINUTE, 0);
	        c.set(Calendar.SECOND, 0);
	          
	        c.set(Calendar.DATE, 1);
	        c.add(Calendar.MONTH, 1);
	        c.add(Calendar.DATE, -1);
	        return c.getTime();
	    }
	  
	    /**
	     * ��ȡ����һ���ж�����
	     * @return
	     */
	    public static int thisMonthTotalDay(){
	          
	        long lastDayMilliSeconds = monthEnd().getTime();
	        long firstDayMilliSeconds = monthBegin().getTime();
	  
	        return (int) ((lastDayMilliSeconds-firstDayMilliSeconds)/millisecondsOfOneDay) +1;
	    }
	      
	    /**
	     *��ȡ���»�ʣ������
	     * @return
	     */
	      
	    public static int thisMonthLeftDay(){
	        long lastDayMilliSeconds = monthEnd().getTime();
	        long toDayMilliSeconds = today().getTime();
	        return (int) ((lastDayMilliSeconds-toDayMilliSeconds)/millisecondsOfOneDay) +1;
	    }  
	      
	    public static void main(String[] args) {
	        System.out.println(Dateutil.monthEnd());
	     
	    }
	}

