package com.yrsoft.common.truckBroker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.vvise.wccyclient.net.Authorization;
import com.vvise.wccyclient.net.TransportClientFactory;
import com.vvise.wccyclient.vo.RestResult;
import com.yrsoft.common.utils.StringUtils;

/**
 * 发送无成承运人资金流水单<p>
 * 发送无车承运人电子路单<p>
 * 
 * @author WANGQI
 * @date 2019年3月1日 下午4:15:47
 */
public class TruckBrokerSendUtil {
	
	/*
	 *无车承运人测试环境
	 */
	public  static final String targetURL="http://1.85.61.203:18086/wccy-dc/send2Logink/v1/send";
	public  static final String authUrl="http://1.85.61.203:18085/wccy-dc/token/sign";
	public  static final String refreshTokenUrl="http://1.85.61.203:18085/wccy-dc/token/refresh";
	public  static final String username="14146";
	public  static final String password="hswl20160918";
	public  static final String resourceId="ECE91161D6670E60E040A8C0970C6ACD";
	public  static final String toaddress="wcjc0001";
	
	/*
	 *无车承运人生产环境
	 */
	/*public  static final String targetURL="http://1.85.61.203:18085/wccy-dc/send2Logink/v1/send";
	public  static final String authUrl="http://1.85.61.203:18085/wccy-dc/token/sign";
	public  static final String refreshTokenUrl="http://1.85.61.203:18085/wccy-dc/token/refresh";
	public  static final String username="14146";
	public  static final String password="hswl20160918";
	public  static final String resourceId="ECE91161D6670E60E040A8C0970C6ACD";
	public  static final String toaddress="wcjc0001";*/ 
	
	//日志类
	public static Logger log = Logger.getLogger(TruckBrokerSendUtil.class);
	
	/**   
	 * 货主评价运单， 发送资金流水单给交通部<p>
	 * 
	 * @param 支付方式
	 *            ---- 支付宝支付,余额支付(现付) order_pay表
	 * @param orderCode
	 *            (运单：order_code) 资金流水单号是为这个资金流水单特意设置的一个编号,你们自己生成即可。
	 *            但是，每个资金流水单的资金流水单号一定不要相同,使用系统运单号作为资金流水单号
	 * @param carrier
	 *            承运人(车主名称)
	 * @param vehicleNumber
	 *            车辆牌照号（运单对应的车辆车牌号）
	 * @param payway
	 *            支付方式 （42：现金）
	 * @param transcationAmount
	 *            订单金额（货运单单车辆运费）
	 * @param sequenceCode
	 *            必填,银行或第三方支付平台的资金流水单号，现金等其他方式可填财务记账号
	 *            1.当支付方式为支付宝支付时,将trade_no赋给sequenceCode
	 *            2.当支付方式为余额支付时,将serial_code(订单流水号)赋给sequenceCode （m_pay_log
	 *            :取其id值）
	 * @param transcationDateTime
	 *            支付宝返回的gmt_paymen交易付款时间 2014-11-27 15:45:57
	 *            （m_pay_log:pay_time支付时间）      
	 * @return:RestResult：报文返回结果      
	 */  
	public static RestResult sendFundFlowData(String orderCode, String carrier, String vehicleNumber, int payway,
			String transcationAmount, String sequenceCode, String transcationDateTime) {
		// 身份验证
		RestResult restResult = Authorization.getToken(username,password,authUrl);
		// 认证成功：0000
		if ("0000".equals(restResult.getCode())) {
			try {
				// 报文的唯一标识符，由系统按GUID规则自动产生
				String messageReferenceNumber = "";
				UUID uuid = UUID.randomUUID();
				messageReferenceNumber = uuid.toString().replace("-", "").substring(0, 17);
				// 报文发送时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String messageSendingDateTime = sdf.format(new Date());
				// 支付方式 参见无车承运人标注电子运单，资金流水单填报说明.pdf Page10
				// (0：支付宝，1：微信，2：银联，3：充值余额, 4：垫资余额， 5：垫支余额)
				String paymentMeansCode = "42";
				if (payway == 0) { paymentMeansCode = "71"; }
				else if (payway== 1) { paymentMeansCode = "72"; }
				else if (payway == 2) {paymentMeansCode = "39"; }
				// 设置待发送的业务报文
				StringBuffer xml = new StringBuffer();
				xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				xml.append("<Root>");

				// 头部信息
				xml.append("<Header>");
				xml.append("<MessageReferenceNumber>" + messageReferenceNumber + "</MessageReferenceNumber>");
				xml.append("<DocumentName>资金流水单</DocumentName>");
				xml.append("<DocumentVersionNumber>2015WCCYR</DocumentVersionNumber>"); // 报文版本号
				xml.append("<SenderCode>14146</SenderCode>"); // 无车承运人企业的物流交换代码
				xml.append("<RecipientCode>wcjc0001</RecipientCode>"); // 监测平台物流交换代码
				xml.append("<MessageSendingDateTime>" + messageSendingDateTime + "</MessageSendingDateTime>"); // 发送日期时间YYYYMMDDhhmmss
				xml.append("<MessageFunctionCode>9</MessageFunctionCode>"); // 报文功能代码
				xml.append("</Header>");

				// 发送报文本体数据
				xml.append("<Body>");
				xml.append("<DocumentNumber>" + orderCode + "</DocumentNumber>"); // 必填,本资金流水单号
				xml.append("<Carrier>" + carrier + "</Carrier>"); // 承运人
				xml.append("<VehicleNumber>" + vehicleNumber + "</VehicleNumber>"); // 车辆牌照号
				xml.append("<LicensePlateTypeCode>01</LicensePlateTypeCode>"); // 牌照类型代码

				xml.append("<ShippingNoteList>");
				xml.append("<ShippingNoteNumber>" + orderCode + "</ShippingNoteNumber>"); // 托运单号
				xml.append("</ShippingNoteList>");

				xml.append("<Financiallist>");
				xml.append("<PaymentMeansCode>" + paymentMeansCode + "</PaymentMeansCode>");
				// xml.append("<BankCode>"+bankCode+"</BankCode>"); //银行代码
				// 必填， 银行或第三方支付平台的资金流水单号，现金等其他方式可填财务记账号
				// 流水号，序列号
				xml.append("<SequenceCode>" + sequenceCode + "</SequenceCode>");
				// 货币金额
				transcationAmount += ".000";
				xml.append("<MonetaryAmount>" + transcationAmount + "</MonetaryAmount>");

				// 必填，资金流水实际发生时间YYYYMMDDHHMMSS
				xml.append("<DateTime>" + transcationDateTime + "</DateTime>");

				xml.append("</Financiallist>");
				xml.append("</Body>");
				xml.append("</Root>");

				// 建立报文发送对象，发送报文
				TransportClientFactory factory = TransportClientFactory.getFactory(refreshTokenUrl);
				restResult = factory.sendRequest(targetURL, xml.toString(),"LOGINK_CN_FREIGHTCHARGES");
						

				// 返回code为0000只是表示数据发送到了无车承运人监管平台,并不表示所发送的数组符合接入规则
				// 报文是否符合规则需要登陆无车承运人网站查看
				if ("0000".equals(restResult.getCode())) {
					log.info("无车承运人资金流水单数据发送成功，运单编号为：" + orderCode);

				} else {
					log.info("无车承运人资金流水单数据上传失败，运单编号为：" + orderCode + ",code:" + restResult.getCode() + "，message:"
						+ restResult.getMessage());
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("上传资金流水单数据接口异常，运单编号为：" + orderCode + "，异常信息：" + e.getMessage());
			}
		}
		return restResult;
	}

	
	
	/**   
	 * 交通部无车承运人电子路单发送报文数据（收货日期时间不能晚于发送报文日期时间）<p>
	 * 
	 * @param orderCode 订单编号(运单编号 order_code)
	 * @param orderCreateDate 订单生成时间(货运单生成时间)
	 * @param startDate 装车后的出发时间（运单确认发货的时间）
	 * @param arriveDate 到达时间(运单确认收货时间)
	 * @param userName 发货人用户名称（货主名称）
	 * @param idCardNo 身份证号
	 * @param startAddress 出发地址（货运单）
	 * @param receiveUserName 收货人名称（货运单）
	 * @param arriveAddress 到达地址（货运单）
	 * @param orderAmount 订单金额（货运单单辆车的运费）
	 * @param carNumber 车牌号
	 * @param loadWeight 车辆载重  两位小数（准牵引质量）
	 * @param yszh 运输证号（道路运输证号）
	 * @param driverName 车主姓名
	 * @param goodsName 物品名称
	 * @param goodsWeight 物品重量,kg 3位小数
	 * @param xkzh 许可证号
	 * @param driverRecordName 司机名称（运输单最终送达司机）
	 * @param qualificationCode 从业资格证号（忽略）
	 * @param driverRecordTelephone 司机电话      
	 * @return:RestResult   报文返回结果
	 */  
	public static RestResult sendWaybillData(String orderCode, String orderCreateDate, String startDate, String arriveDate,String userName,String idCardNo,
			String startAddress, String receiveUserName,String  arriveAddress, String orderAmount, String carNumber,
			String loadWeight, String yszh,String driverName, String goodsName, String goodsWeight,
			String xkzh,String driverRecordName,String qualificationCode,
			String driverRecordTelephone, String startCityCode, String arriveCityCode) {
		//身份验证
		RestResult restResult = Authorization.getToken(username,password,authUrl);
		// 认证成功：0000
		if ("0000".equals(restResult.getCode())) {
			try {
				// 设置待发送的业务报文
				StringBuffer xml = new StringBuffer();
				xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				xml.append("<Root>");
				
				//头部信息
				xml.append("<Header>");
				xml.append("<MessageReferenceNumber>" + orderCode + "</MessageReferenceNumber>"); 
				xml.append("<DocumentName>无车承运人电子路单</DocumentName>"); // 单证名称 固定
				xml.append("<DocumentVersionNumber>2015WCCYR</DocumentVersionNumber>"); 
				xml.append("<SenderCode>14146</SenderCode>"); // 发送方代码 无车承运人物流交换代码
				xml.append("<RecipientCode>wcjc0001</RecipientCode>"); 
				
				// process the arrivaeDate for use
				SimpleDateFormat format =  new SimpleDateFormat("yyyyMMddHHmmss");  
			    Long time=new Long(arriveDate+"000");  
				arriveDate = format.format(time); 
				
				xml.append("<MessageSendingDateTime>" + arriveDate + "</MessageSendingDateTime>"); 
				xml.append("<MessageFunctionCode>9</MessageFunctionCode>"); 
				xml.append("</Header>");
				
				//要发送的报文数据本体
				xml.append("<Body>");
				xml.append("<OriginalDocumentNumber>" + orderCode + "</OriginalDocumentNumber>"); // 原始单号
				xml.append("<ShippingNoteNumber>" + orderCode + "</ShippingNoteNumber>"); // 托运单号
				xml.append("<Carrier>西安和硕物流科技有限公司</Carrier>"); // 承运人 无车承运试点企业名称 固定
				xml.append("<UnifiedSocialCreditIdentifier>91610133MA6TYE1R5N</UnifiedSocialCreditIdentifier>"); 
				
				// process the orderCreateDate for use
			    Long time2=new Long(orderCreateDate+"000");  
			    orderCreateDate = format.format(time2); 
				xml.append("<ConsignmentDateTime>" + orderCreateDate + "</ConsignmentDateTime>"); // 无车承运人系统正式生成运单的日期 YYYYMMDDhhmmss
				
				// 业务类型是有分别的-----------------------------------------------------------------
				xml.append("<BusinessTypeCode>1002996</BusinessTypeCode>"); // 业务类型代码
				// 业务类型是有分别的-----------------------------------------------------------------
				
				// process the startDate for use
				Long time3=new Long(startDate+"000");  
				startDate = format.format(time3); 
				//货物装车后的发车时间 （运单确认发货的时间）：YYYYMMDDhhmmss
				xml.append("<DespatchActualDateTime>" + startDate + "</DespatchActualDateTime>"); 
				//到达时间(运单确认收货时间)
				xml.append("<GoodsReceiptDateTime>" + arriveDate + "</GoodsReceiptDateTime>"); 
				
				// 发货方信息
				xml.append("<ConsignorInfo>"); 
				if(StringUtils.isNotEmpty(userName)) {
					xml.append("<Consignor>" + userName + "</Consignor>"); // 选填 发货人 单位或个人
				}
				
				if(StringUtils.isNotEmpty(idCardNo)) {
					xml.append("<PersonalIdentityDocument>" + idCardNo + "</PersonalIdentityDocument>"); 
				}
				
				if(StringUtils.isNotEmpty(startAddress)) {
					xml.append("<PlaceOfLoading>"+startAddress+"</PlaceOfLoading>"); // 装货地点
				}
				
				xml.append("<CountrySubdivisionCode>" + startCityCode + "</CountrySubdivisionCode>");
				xml.append("</ConsignorInfo>");
				
				// 收货方信息
				xml.append("<ConsigneeInfo>"); 
				if(StringUtils.isNotEmpty(receiveUserName)) {
					xml.append("<Consignee>" + receiveUserName + "</Consignee>"); // 选填
				}
				if(StringUtils.isNotEmpty(arriveAddress)) {
					xml.append("<GoodsReceiptPlace>" + arriveAddress + "</GoodsReceiptPlace>");  // 选填
				}
				xml.append("<CountrySubdivisionCode>" + arriveCityCode + "</CountrySubdivisionCode>"); // 收货地点的国家行政区划代码
				xml.append("</ConsigneeInfo>");
				
				// 费用信息
				xml.append("<PriceInfo>"); 
				xml.append("<TotalMonetaryAmount>" + orderAmount + "</TotalMonetaryAmount>"); // 货币总金额
				xml.append("</PriceInfo>");
				
				// 车辆信息
				xml.append("<VehicleInfo>"); 
				xml.append("<LicensePlateTypeCode>01</LicensePlateTypeCode>"); // 牌照类型代码
				xml.append("<VehicleNumber>" + carNumber + "</VehicleNumber>"); // 车辆牌照号
				
				// 车辆类型 是有分别的 -----------------------------------------------------------------------------------
				xml.append("<VehicleClassificationCode>Q00</VehicleClassificationCode>"); // 车辆分类代码
				// 车辆类型 是有分别的 -----------------------------------------------------------------------------------
	
				xml.append("<VehicleTonnage>" + loadWeight + "</VehicleTonnage>"); // 车辆载重量(吨)
				xml.append("<RoadTransportCertificateNumber>" + yszh + "</RoadTransportCertificateNumber>"); // 道路运输证号
				
				if(StringUtils.isNotEmpty(driverName)) {
					xml.append("<Owner>" + driverName + "</Owner>"); // 选填 所有人
				}
				if(StringUtils.isNotEmpty(xkzh)) {
					xml.append("<PermitNumber>" + xkzh + "</PermitNumber>"); // 选填 许可证编号
				}
				
				//司机信息
				// 如果driverRecordName，qualificationCode，driverRecordTelephone都是空没有Driver节点
				// || StringUtil.isNotEmpty(qualificationCode) 
				if(StringUtils.isNotEmpty(driverRecordName) || StringUtils.isNotEmpty(driverRecordTelephone)) {
					xml.append("<Driver>"); // 驾驶员 可多个  选填
						if(StringUtils.isNotEmpty(driverRecordName)) {
							xml.append("<NameOfPerson>" + driverRecordName + "</NameOfPerson>"); // 选填
						}
						/*if(StringUtil.isNotEmpty(qualificationCode)) {
							xml.append("<QualificationCertificateNumber>" + qualificationCode + "</QualificationCertificateNumber>"); // 选填
						}*/
						if(StringUtils.isNotEmpty(driverRecordTelephone)) {
							xml.append("<TelephoneNumber>" + driverRecordTelephone + "</TelephoneNumber>"); // 选填
						}
					xml.append("</Driver>");
				}
				
				// 货物信息 如一车货有不同货物 则可循环
				xml.append("<GoodsInfo>"); 
				xml.append("<DescriptionOfGoods>" + goodsName + "</DescriptionOfGoods>"); // 货物名称
				xml.append("<CargoTypeClassificationCode>999</CargoTypeClassificationCode>"); // 货物类型分类代码
				xml.append("<GoodsItemGrossWeight>" + goodsWeight + "</GoodsItemGrossWeight>"); // 货物项毛重
				
				
				xml.append("</GoodsInfo>");
				xml.append("</VehicleInfo>");
				xml.append("</Body>");
				xml.append("</Root>");
	
				TransportClientFactory factory = TransportClientFactory.getFactory(refreshTokenUrl);
				restResult = factory.sendRequest(targetURL, xml.toString(), "LOGINK_CN_FREIGHTBROKER_WAYBILL");
				// 返回code为0000只是表示数据发送到了无车承运人监管平台,并不表示所发送的数组符合接入规则
				// 报文是否符合规则需要登陆无车承运人网站查看
				if ("0000".equals(restResult.getCode())) {
					log.info("无车承运人电子路单数据发送成功，运单编号为：" + orderCode);
				} else {
					log.info("无车承运人电子路单数据上传失败，运单编号为：" + orderCode + ",code:" + restResult.getCode() + "，message:"+ restResult.getMessage());
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("上传无车承运人电子路单接口异常,运单编号为：" + orderCode + "，异常信息：" + e.getMessage());
			}
		}
		return restResult;
	}
	
	
	
	//test
	/*public static void main(String[] args) {
		  String orderCode = "201911041627549646258";
		  String orderCreateDate = "1551432420";
		  String startDate = "1551259620";
		  String arriveDate = "1551432420";
		  String userName = "浙江康泰制造有限公司";
		  String idCardNo = "330102198402124417";
		  String startAddress = "陕西省西安市长安区";
		  String receiveUserName = "韩梅梅";
		  String arriveAddress = "浙江省杭州市余杭区";
		 // double orderAmount = 500.000;
		  //String  orderAmountStr = String.format("%.3f", orderAmount);
		  String carNumber = "晋K26717";
		  String loadWeight = "50.00"; // 保留两位小数
		  String yszh = "330111003790";
		  String driverName = "李雷雷";
		  String goodsName = "书信";
		  String goodsWeight = "20.333";
		  String xkzh = "330301000307";
		  String goodsVolume = "11.3333";
		  String goodsCount = "2";
		  String driverRecordName = "马化腾";
		  String qualificationCode  = "431224198708273098";
		  String driverRecordTelephone = "13379135758";
		  String startCityCode = "610116"; // 长安区
		  //String startCityCode = "610100"; // 西安市
		  String arriveCityCode = "330110";
		RestResult tu =  TruckBrokerSendUtil.sendWaybillData(orderCode, orderCreateDate, startDate, arriveDate, userName, idCardNo, startAddress, receiveUserName, arriveAddress,
				"500.000", carNumber,  loadWeight, yszh, driverName, goodsName, goodsWeight, xkzh, goodsVolume, goodsCount, driverRecordName, qualificationCode, 
				driverRecordTelephone, startCityCode, arriveCityCode) ;
		System.out.println(tu);
	}
	*/
	
	// test
	/*public static void main(String[] args) {
		String orderCode = "201903290940428142588";
		String carrier = "澄城县凯达汽车贸易有限公司";
		String vehicleNumber = "陕EC9776";
		int payway = 1; // 余额支付
		String sequenceCode = "201803290940464235746";
		String transcationDateTime = "20180329094046";
		String  transcationAmount = String.valueOf(10*30000);
		RestResult tu =TruckBrokerFundFlowSendUtil.sendFundsFlowData(orderCode, carrier, vehicleNumber, payway, transcationAmount, sequenceCode, transcationDateTime);
		System.out.println(tu);
		Long time=Long.parseLong("1536399752") * 1000;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		transcationDateTime = format.format(time);
		System.out.println(transcationDateTime);
	}*/

}