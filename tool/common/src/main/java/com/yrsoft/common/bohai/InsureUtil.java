package com.yrsoft.common.bohai;

import java.util.Date;
import java.util.UUID;

import com.yrsoft.common.config.Global;
import com.yrsoft.common.utils.DateUtils;
import org.apache.log4j.Logger;


/**
 * 渤海保险相关操作工具类
 * 
 * 核保,承保接口
 * 
 * @author LU
 * @param
 * @date 2018年7月6日 上午11:22:53
 */
public class InsureUtil {

	// 日志类
	public static Logger log = Logger.getLogger(InsureUtil.class);

	/**   
	 * @Title: submitInsure 
	 * @Description:调用渤海保险的核保和承保接口     
	 * @param insureType
	 *            保单类型（1：货主物品险2：车主车辆20万定额保险）默认为：“1”
	 * @param waybillNumber
	 *            运单编号：(waybill_number），唯一的   必填项
	 * @param target
	 *            投保人类型（货主认证状态（1：个人，2：企业））
	 * @param carNum
	 *            车辆车牌号：carNumber
	 * @param carVin
	 *            （车辆识别代号：carVin）车架号
	 * @param carLoad
	 *            （准牵引质量：total_traction_weight 存入的单位是:kg*1000）车辆载重，单位：吨
	 * @param startAddress
	 *            （货运单起始地址：地址详情（省+市+区+详情））起始地址
	 * @param arriveAddress
	 *            （货运单的目的地址：地址详情（省+市+区+详情））目的地址
	 * @param idCard
	 *            （个人：身份证/ 企业：营业执照号）身份证号/公司税务登记号
	 * @param userName
	 *            （货主：个人：身份证:name/ 企业：营业执照公司名称:company_name） 用户姓名/企业的公司名称
	 * @param userSex
	 *            用户性别(货主个人：性别)（1：男，2：女）
	 * @param birthday
	 *            用户生日（个人），格式：yyyy-MM-dd
	 * @param telephone
	 *            手机号（会员表：手机号）
	 * @param insureAmount
	 *            保费（货运单保险费：insureAmount 每车辆对应的保险费）
	 * @param insureLimit
	 *            保额（保险费*1000）
	 * @param goodsTypeName
	 *            货物类型名称（默认：普通货物）
	 * @param goodsCount
	 *            货物件数（默认：1）
	 * @param goodsRemark
	 *            货物明细描述（货运单：goodsRemark）
	 * @return: String  ：返回调用报文的结果
	 * @throws   
	 */  
	public static String submitInsure(String insureType, String waybillNumber, String target, String carNum,
			String carVin, String carLoad, String startAddress, String arriveAddress, String idCard, String userName,
			String userSex, String birthday, String telephone, String insureAmount, String insureLimit,
			String goodsTypeName, String goodsCount, String goodsRemark) {
		try {
			// 组装报文
			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
			sb.append("<B2BRequestXml>");
			//头部信息
			sb.append("<Header>");
			// （必填）交易码 核保请求:01 ，承保请求:09  ，退保请求:02， 二核请求:0102 ，电子单下载:10 add by edi
			sb.append("<TRAN_CODE>01</TRAN_CODE>"); 
			// （必填）交易日期
			sb.append("<BK_ACCT_DATE>" + DateUtils.date2Str(new Date(), "yyyy-MM-dd") + "</BK_ACCT_DATE>");
			// （必填）交易时间
			sb.append("<BK_ACCT_TIME>" + DateUtils.date2Str(new Date(), "HH:mm:ss") + "</BK_ACCT_TIME>");
			 // （必填）运单编号：waybillNumber   贯穿保单整个生命周期
			sb.append("<BK_SERIAL>" + waybillNumber + "</BK_SERIAL>");
			 // （必填）唯一标识  用于标记与EDI单次交易  每次交易该号都唯一
			sb.append("<UNIQUE_IDENTIFICATION>" + UUID.randomUUID().toString() + "</UNIQUE_IDENTIFICATION>");
			// （必填）险类代码：如：家财险、意外险
			sb.append("<INSURENCE_CODE>bohai</INSURENCE_CODE>"); 
			// （必填）产品编码 ， 与下文产品编码一致，减少深度，方便判断用， 国内水路陆路货运保险：0617
			sb.append("<PRODUCT_SOLE_CODE>0617</PRODUCT_SOLE_CODE>"); 
			 // （必填）用户账号
			sb.append("<USER_ID>b2b_laosiji</USER_ID>");
			 // （必填）用户代码
			sb.append("<USER_CODE>b2b_laosiji</USER_CODE>");
			sb.append("</Header>");
			
			//保单数据信息传送
			sb.append("<Request>");
			sb.append("<ASHPolicy>");
			
			 // 保单基本信息，非空
			sb.append("<PolicyBaseINFO>");
			sb.append("<ResourceType>B2B</ResourceType>"); // 出单来源
			sb.append("<IssueCompany>61001601</IssueCompany>"); // 出单机构
			sb.append("<CompanyCode>61001601</CompanyCode>"); // 业务归属机构
			sb.append("<SalesmanCode>161002357</SalesmanCode>"); // 业务员
			sb.append("<OperatorCode>161048315</OperatorCode>"); // 出单员代码
			sb.append("<OperatorName>王晓妮</OperatorName>"); // 出单员姓名
			sb.append("<AgreementNo></AgreementNo>"); // 协议号代码:待定
			sb.append("<CommissionPercent>38</CommissionPercent>"); // 手续费比例
			sb.append("<CommissionAmount></CommissionAmount>"); // 手续费金额
			sb.append("<BusinessSource>1990203</BusinessSource>"); // 业务来源 ：网销--1990106    专业代理--1190203
			sb.append("<BusinessSourceDetail>1990203001</BusinessSourceDetail>"); // 业务来源明：网销-1990106  其他--1190203001
			sb.append("<AgentCode>610201015037</AgentCode>"); // 代理人编码
			sb.append("<AgentName>陕西华翎保险代理有限公司</AgentName>"); // 代理人名称
			sb.append("<BusinessType>01</BusinessType>"); // 业务类型 01 -拓展型 02-维护型 03 -综合型														
			sb.append("<BusinessChannel>3</BusinessChannel>"); // 业务渠道 1-柜台业务  2-电話业务 3-网上业务 4-上门业务																
			sb.append("<BusinessSymbol>008</BusinessSymbol>"); // 标示类别 008电网销
			sb.append("<BusinessDetailSymbol>00013</BusinessDetailSymbol>"); // 标示细分 	 00013网销下的微信
			sb.append("<ApplyPersonnelNum>1</ApplyPersonnelNum>"); // 投保人数，例如：1，非空
			
			// 与被保人关系，非空。见数据字典1：雇佣 2：本人 3： 配偶 4： 父子（女）或母子（女）5： 抚养 6：扶养 7：赡养8：法定9：其他
			sb.append("<RelationShipWithInsured>2</RelationShipWithInsured>"); 													
			sb.append("<SumPremium>" + insureAmount + "</SumPremium>"); // 订单保费合计
			sb.append("<LicensePlate>" + carNum + "</LicensePlate>"); // 车牌号
			sb.append("<Approved>" + carLoad + "</Approved>"); // 核定载重吨
			sb.append("<FrameNumber>" + carVin + "</FrameNumber>"); // 车架号
			sb.append("<Cartype>00</Cartype>"); // 车辆类型
			sb.append("<Departure>" + startAddress + "</Departure>"); // 出发地
			sb.append("<Objective>" + arriveAddress + "</Objective>"); // 目的地
			sb.append("<conveyanceTypeName>货车</conveyanceTypeName>"); // 运输方式(名称)
			sb.append("<conveyanceCode>货车</conveyanceCode>"); // 运输工具类型
			sb.append("<voyageNo>货车</voyageNo>"); // 运输工具名称
			sb.append("<conveyanceLicenseNo>" + waybillNumber + "</conveyanceLicenseNo>"); // 发票号/运单号/提单号
			sb.append("<isContainer>001</isContainer>"); // 是否集装箱货物
			sb.append("<whetherShipTransport>001</whetherShipTransport>"); // 是否整船运输
			sb.append("<SumAmount>" + insureLimit + "</SumAmount>"); // 订单总保额 非空
			sb.append("<InsuranceStartTime>" + DateUtils.date2Str(new Date(), "yyyy-MM-dd HH:mm:ss")
					+ "</InsuranceStartTime>"); // 保险起期，非空，格式YYYY-MM-DD hh:mm:ss
			sb.append(
					"<InsuranceEndTime>" + DateUtils.date2Str(DateUtils.addDate(new Date(), 5, 15), "yyyy-MM-dd HH:mm:ss")
							+ "</InsuranceEndTime>"); // 保险止期，非空，格式YYYY-MM-DD 	hh:mm:ss
			sb.append("<CurrecyCode>CNY</CurrecyCode>"); // 币种，非空
			sb.append("<CodInd>Y</CodInd>"); // 见费标志
			sb.append("<BenifitType>01</BenifitType>"); // 受益方式 01-法定受益人
			sb.append("<DistributionType></DistributionType>"); // 保单配送方式
			sb.append("<CoveragePeriod>D</CoveragePeriod>"); // 保障类型
			sb.append("<CoverageYear>15</CoverageYear>"); // 保障期限
			sb.append("<FeeType>2</FeeType>"); // 保费计算方式
			sb.append("<ChargePeriod></ChargePeriod>"); // 缴费类型
			sb.append("<ChargeYear></ChargeYear>"); // 缴费期限
			sb.append("<PaymentMethods></PaymentMethods>"); // 缴费方式
			sb.append("<Postage></Postage>"); // 邮费
			sb.append("<ProChannel></ProChannel>"); // 渠道小类 置空
			sb.append("<DimportCode>B-SPEN-4608</DimportCode>"); // 维度编码 置空
			sb.append("</PolicyBaseINFO>");

			//投保人信息
			sb.append("<ApplicantINFO>"); 
			sb.append("<IndividualPersonnelInfo>"); // 个人投保人信息，当投保人为个人时非空
			sb.append("<ApplicantType>" + target + "</ApplicantType>"); // 投保人类型，非空
			sb.append("<ApplicantCode>1</ApplicantCode>"); // 投保人编码，非空
			sb.append("<ApplicantName>" + userName + "</ApplicantName>"); // 投保人名称，非空
			sb.append("<SexCode>" + userSex + "</SexCode>"); // 性别 1：男，2：女，非空
			String certType = target.equals("2") ? "3" : "01"; // 不同投保人类型，证件类型不一样
			 // 个人：证件类型：  01：身份证  02：护照  03：军人证  04：驾驶证  05：港澳回乡证或台胞证  07-中国护照  99：其他，非空
			// 企业： 证件类型：组织机构代码证1  税务登记证2  营业执照3  其他99
			sb.append("<CertificateType>" + certType + "</CertificateType>");
			sb.append("<CertificateNo>" + idCard + "</CertificateNo>"); // 证件号码，非空
			sb.append("<CertificateEFFStartDate></CertificateEFFStartDate>"); // 证件有效起始时间
			sb.append("<CertificateEFFEndDate></CertificateEFFEndDate>"); // 证件有效结束时间
			sb.append("<FamilyNameSpell/>"); // 姓拼音，可空
			sb.append("<FirstNameSpell/>"); // 名拼音，可空
			sb.append("<EnglishName/>"); // 英文名（境外险时专用，必须）: 长度必须为2~38个字符	，只能由半角英文字母、空格、/、.组成，且不能包含连续两个空格，首尾不能有空格
			sb.append("<InsuredAge></InsuredAge>"); // 人员年龄
			sb.append("<Birthday>" + birthday + "</Birthday>"); // 生日，非空  格式YYYY-MM-DD   默认1970-01-01											
			sb.append("<MobilePhone>" + telephone + "</MobilePhone>"); // 手机号码，可空
			sb.append("<Marriage></Marriage>"); // 婚姻状况 可空
			sb.append("<Email></Email>"); // email地址，可空
			sb.append("<ProvinceName>默认</ProvinceName>"); // 投保人省级居住区域名称 可空
			sb.append("<ProvinceCode>000000</ProvinceCode>"); // 投保人省级居住区域编码 可空
			sb.append("<CityName>默认</CityName>"); // 投保人市级居住区域名称 可空
			sb.append("<CityCode>000000</CityCode>"); // 投保人市级居住区域编码 可空
			sb.append("<CountyName>默认</CountyName>"); // 投保人县级居住区域名称 可空
			sb.append("<CountyCode>000000</CountyCode>"); // 投保人县级居住区域编码 可空
			sb.append("<Address>默认</Address>"); // 投保人联系地址 可空
			sb.append("<PostCode></PostCode>"); // 投保人邮政编码 可空
			sb.append("<SpecialClient>00</SpecialClient>"); // 客户类型 默认值（00普通客户）
			sb.append("<InsuredRelation>01</InsuredRelation>"); // 关系 01默认值
			sb.append("<MoneyLaunderingInd>3</MoneyLaunderingInd>"); // 洗钱风险	 3默认值	 低													
			sb.append("<JobUnitName>默认</JobUnitName>"); // 工作单位 默认默认值
			sb.append("<CompanyName></CompanyName>"); // 企业名称
			sb.append("</IndividualPersonnelInfo>");
			sb.append("</ApplicantINFO>");

			// 被保险人信息
			sb.append("<InsurantINFOList>"); 
			sb.append("<InsurantINFO>");
			sb.append("<InsurantName>" + userName + "</InsurantName>"); // 人员名称，非空
			sb.append("<SexCode>" + userSex + "</SexCode>"); // 性别 1：男，2：女，非空
			// 证件类型，01：身份证  02：护照   03：军人证   04：驾驶证  05：港澳回乡证或台胞证  07-中国护照  99：其他，非空
			sb.append("<CertificateType>" + certType + "</CertificateType>"); 
			sb.append("<CertificateNO>" + idCard + "</CertificateNO>"); // 证件号码，非空
			sb.append("<CertificateEFFStartDate></CertificateEFFStartDate>"); // 证件有效起始时间
			sb.append("<CertificateEFFEndDate></CertificateEFFEndDate>"); // 证件有效结束时间
			sb.append("<FamilyNameSpell/>"); // 姓拼音，可空
			sb.append("<FirstNameSpell/>"); // 名拼音，可空
			sb.append("<EnglishName/>"); // 英文名
			sb.append("<InsuredTypeCD>" + target + "</InsuredTypeCD>"); // 被保险人类型// 1-个人	// 2-单位
			sb.append("<IsInsuredFlag>0</IsInsuredFlag>"); // 保单持有人标志 (0投被同一人// 1投被非同一人) 默认0
			 // 与投保人关系
			// 01本人10配偶11丈夫12妻子20儿子 30女儿40儿女50父母 51父亲52母亲53继父54继母55叔伯56阿姨57兄弟58姐妹59外公 60亲属61兄弟 62奶奶 67姐妹 80单位 81雇员 82雇主  99其他
			sb.append("<InsuredRelationCode>01</InsuredRelationCode>");
			sb.append("<InsuredRelationCodeEN></InsuredRelationCodeEN>"); // 与投保人关系英文编码
			sb.append("<PersonnelAge></PersonnelAge>"); // 人员年龄，可空
			sb.append("<Birthday>" + birthday + "</Birthday>"); // 生日，非空，格式YYYY-MM-DD
			sb.append("<ProfessionNameOne></ProfessionNameOne>"); // 一级职业名称，可空
			sb.append("<ProfessionCodeOne>000000</ProfessionCodeOne>"); // 一级职业代码，可空
			sb.append("<ProfessionNameTwo/>"); // 二级职业名称，可空
			sb.append("<ProfessionCodeTwo/>"); // 二级职业代码，可空
			sb.append("<ProfessionNameThree/>"); // 三级职业名称，可空
			sb.append("<ProfessionCodeThree/>"); // 三级职业代码，可空
			sb.append("<MobileTelephone>" + telephone + "</MobileTelephone>"); // 手机号码
			sb.append("<Email></Email>"); // email地址
			sb.append("<Marriage></Marriage>"); // 婚姻状况
			sb.append("<Nationality/>"); // 国籍
			sb.append("<Height/>"); // 身高
			sb.append("<Weight/>"); // 体重
			sb.append("<RegionName>默认</RegionName>"); // 被保人省级居住区域名称
			sb.append("<RegionCode>000000</RegionCode>"); // 被保人省级居住区域编码
			sb.append("<CityName>默认</CityName>"); // 被保人市级居住区域名称
			sb.append("<CityCode>000000</CityCode>"); // 被保人市级居住区域编码
			sb.append("<CountyName>默认</CountyName>"); // 投保人县级居住区域名称
			sb.append("<CountyCode>000000</CountyCode>"); // 投保人县级居住区域编码
			sb.append("<Address>默认</Address>"); // 被保人联系地址
			sb.append("<Postcode>000000</Postcode>"); // 被保人邮政编码
			sb.append("<SpecialClient>00</SpecialClient>"); // 客户类型 默认值（00-普通客户）
			sb.append("<CompanyName></CompanyName>"); // 企业名称
			sb.append("<BusinessAddress></BusinessAddress>"); // 被保人营业地址
			sb.append("</InsurantINFO>");
			sb.append("</InsurantINFOList>");

			// 产品信息
			sb.append("<ProductINFO>"); 
			sb.append("<ProductName>国内公路货物运输定额保险</ProductName>"); // 产品名称，非空
			sb.append("<ProductCode>0617</ProductCode>"); // 产品代码，非空
			sb.append("<ApplyNum>1</ApplyNum>"); // 投保份数，非空
			sb.append("<TotalPremium>" + insureAmount + "</TotalPremium>"); // 实际保费合计，非空
			sb.append("<PlanINFOList>"); // 套餐（计划）信息列表
			sb.append("<PlanINFO>");
			sb.append("<Mark></Mark>"); // 主附险标志
			sb.append("<PlanCode>0617A</PlanCode>"); // 计划代码，非空
			sb.append("<PlanName></PlanName>"); // 计划名称
			sb.append("<InsuranceBeginTime>" + DateUtils.date2Str(new Date(), "yyyy-MM-dd HH:mm:ss")
					+ "</InsuranceBeginTime>"); // 保险起期，非空，格式YYYY-MM-DD HH:mm:ss
			sb.append(
					"<InsuranceEndTime>" + DateUtils.date2Str(DateUtils.addDate(new Date(), 5, 15), "yyyy-MM-dd HH:mm:ss")
							+ "</InsuranceEndTime>"); // 保险止期，非空，格式YYYY-MM-DD 	HH:mm:ss									
			sb.append("<Amount>" + insureLimit + "</Amount>"); // 保额
			sb.append("<Premium>" + insureAmount + "</Premium>"); // 实际保费合计，非空
			sb.append("<ApplyNum>1</ApplyNum>"); // 投保份数，非空
			sb.append("<ItemKindList>"); // 险别信息类别
			sb.append("<ItemKind>"); // 险别信息
			sb.append("<SerialNo>1</SerialNo>"); // 序列号
			sb.append("<RiskCode>0617</RiskCode>"); // 险种代码
			sb.append("<RiskName>国内水路、陆路货物运输保险（单程）</RiskName>"); // 险种名称
			sb.append("<KindCode>0617001</KindCode>"); // 险别代码
			sb.append("<KindName>国内水路、陆路货物运输保险（单程）</KindName>"); // 险别名称
			sb.append("<Rate></Rate>"); // 费率
			sb.append("<Amount>" + insureLimit + "</Amount>"); // 保额
			sb.append("<Premium>" + insureAmount + "</Premium>"); // 保费
			sb.append("<Rate>0</Rate>"); // 费率
			sb.append("<CalculateFlag/>"); // 计算标志位
			sb.append("<MainOrAdditionalFlag>1</MainOrAdditionalFlag>"); // 主险附加险标志位
			sb.append("</ItemKind>");
			sb.append("</ItemKindList>");
			sb.append("<EngageINFOList>"); // 特别约定
			sb.append("<EngageINFO>"); // 特别约定信息-**增加** 确认点
			sb.append("<EngageCode></EngageCode>"); // 特别约定代码-**增加** 确认点
			sb.append("<EngageName></EngageName>"); // 特别约定名称-**增加** 确认点
			sb.append("<EngageDesc></EngageDesc>"); // 特别约定描述-**增加** 确认点
			sb.append("</EngageINFO>");
			sb.append("</EngageINFOList>"); // 1个险种包含1或n个险别（责任），非空，可包含1或n个ItemKind
			sb.append("</PlanINFO>");
			sb.append("</PlanINFOList>");

			sb.append("<itemCargoDetailList>");
			sb.append("<itemCargoDetailDto>");
			sb.append("<itemDetailCode>9999</itemDetailCode>"); // 货物类型代码
			sb.append("<itemDetailName>" + goodsTypeName + "</itemDetailName>"); // 货物类型名称
			sb.append("<itemDetailList>" + goodsRemark + "</itemDetailList>"); // 货物明细
			sb.append("<quantity>" + goodsCount + "</quantity>"); // 货物件数
			sb.append("</itemCargoDetailDto>");
			sb.append("</itemCargoDetailList>");

			// 燃气险
			sb.append("<gas>"); 
			sb.append("<gasAmount>0</gasAmount>");
			sb.append("<insurebaseinfosize>1</insurebaseinfosize>");
			sb.append("<insureNumber>1</insureNumber>");
			sb.append("<familyAddress></familyAddress>");
			sb.append("</gas>");
			
			// 学生意外伤残险
			sb.append("<School>"); 
			sb.append("<Banji></Banji>");
			sb.append("<Name></Name>");
			sb.append("<Type></Type>");
			sb.append("</School>");
			
			 // 车膜险1724
			sb.append("<Car>");
			sb.append("<FilmBrand></FilmBrand>");
			sb.append("<FilmType></FilmType>");
			sb.append("<LicensePlate></LicensePlate>");
			sb.append("<UseNature></UseNature>");
			sb.append("</Car>");
			
			// 麻醉险
			sb.append("<Yiliao>"); 
			sb.append("<Hospital></Hospital>");
			sb.append("<ShouShuName></ShouShuName>");
			sb.append("<MazuiName></MazuiName>");
			sb.append("<MazuiType></MazuiType>");
			sb.append("</Yiliao>");
			
			// 婚庆险
			sb.append("<Hunxian>"); 
			sb.append("<Province></Province>");
			sb.append("<City></City>");
			sb.append("<Adress></Adress>");
			sb.append("<WeddingDay></WeddingDay>");
			sb.append("</Hunxian>");
			
			// 财险信息
			sb.append("<PLYTGT>"); 
			sb.append("<BuildingType></BuildingType>"); // 建筑类型（住宅类，商用等等）
			sb.append("<BuildingAddr></BuildingAddr>"); // 地址所在区域
			sb.append("<BuildingLevel></BuildingLevel>"); // 建筑等级
			sb.append("<BuildingStructure></BuildingStructure>"); // 房屋建筑结构
			sb.append("<BuildingProvinceCode></BuildingProvinceCode>"); // 房屋所在的省代码
			sb.append("<BuildingProvinceCName></BuildingProvinceCName>"); // 房屋所在的省名称
			sb.append("<BuildingCityCode></BuildingCityCode>"); // 房屋所在的市代码
			sb.append("<BuildingCityCName></BuildingCityCName>"); // 房屋所在的市名字
			sb.append("<ItemDistrictCode></ItemDistrictCode>"); // 县区编码
			sb.append("<ItemDistrictCName></ItemDistrictCName>"); // 区县名称
			sb.append("<HomePostCode></HomePostCode>"); // 房屋邮编
			sb.append("<SelectAmount></SelectAmount>"); // 可选保额
			sb.append("<SelectTime></SelectTime>"); // 可选时间
			sb.append("<ItemPropertyDetailList>"); // 家财险标的物和对应险别信息列表
			sb.append("</ItemPropertyDetailList>");
			sb.append("</PLYTGT>");
			
			// 食品险
			sb.append("<Food>"); 
			sb.append("<Predict></Predict>");
			sb.append("</Food>");
			sb.append("</ProductINFO>");
			
			sb.append("</ASHPolicy>");
			sb.append("</Request>");
			sb.append("</B2BRequestXml>");
			
			log.info("调用渤海保险的核保接口请求报文-------------------" + sb.toString());
			//System.out.println("调用渤海保险的核保接口请求报文-------------------" + sb.toString());

			String key = Global.getBoHaiKey()+sb.toString();
			key = MD5Util.encryptionTo32Bit(key);
			key = key.toUpperCase();

			// 调用接口发送报文数据
			String resultStr =HttpClientUtil.sendPost(Global.getBoHaiIp()+"?key="+key,sb.toString(), "UTF-8");
			 
			log.info("投保人电话：" + telephone + "，调用核保接口返回的报文结果：" + resultStr);
			return resultStr;

		} catch (Exception e) {
			e.printStackTrace();
			log.error("发送渤海保险核保报文接口异常：运单号为"+waybillNumber+",异常信息为："+e.getMessage());
			return null;
		}
	}

	/**
	 * 调用渤海保险的承保接口
	 * 
	 * @param applyPolicyNo
	 *            （核保成功返回的值：<ApplyPolicyNo>5610116012018361091</ApplyPolicyNo> ）
	 *              投保单号，从核保接口返回参数中获取
	 * @param waybillNumber
	 *            订单编号（运单编号 ：waybillNumber）
	 * @param userName
	 *            用户姓名/企业的公司名称
	 * @param insureAmount
	 *            保费
	 * @param insureLimit
	 *            保额
	 */
	public static  String generateInsure(String applyPolicyNo, String waybillNumber, String userName,
			String insureAmount, String insureLimit) {
		try {
			// 组装报文
			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
			sb.append("<B2BRequestXml>");
			//头部信息
			sb.append("<Header>");
			sb.append("<TRAN_CODE>09</TRAN_CODE>"); // （必填）交易码 核保请求:01 承保请求:09  退保请求:02 二核请求:0102  电子单下载:10 add by edi
			sb.append("<BK_ACCT_DATE>" + DateUtils.date2Str(new Date(), "yyyy-MM-dd") + "</BK_ACCT_DATE>"); // （必填）交易日期
			sb.append("<BK_ACCT_TIME>" + DateUtils.date2Str(new Date(), "HH:mm:ss") + "</BK_ACCT_TIME>"); // （必填）交易时间
			sb.append("<BK_SERIAL>" + waybillNumber + "</BK_SERIAL>"); // （必填）订单号  贯穿保单整个生命周期
			sb.append("<UNIQUE_IDENTIFICATION>" + UUID.randomUUID().toString() + "</UNIQUE_IDENTIFICATION>"); // （必填）唯一标识,用于标记与EDI单次交易 ,每次交易该号都唯一																								 
			sb.append("<INSURENCE_CODE>bohai</INSURENCE_CODE>"); // （必填）险类代码：如：家财险、意外险
			sb.append("<PRODUCT_SOLE_CODE>0617</PRODUCT_SOLE_CODE>"); // （必填）产品编码,与下文产品编码一致，减少深度，方便判断用，国内水路陆路货运保险:0617																		
			sb.append("<USER_ID>b2b_laosiji</USER_ID>"); // （必填）用户账号
			sb.append("<USER_CODE>b2b_laosiji</USER_CODE>"); // （必填）用户代码
			sb.append("</Header>");
			
			//请求数据信息
			sb.append("<Request>");
			sb.append("<TradeInfoDto>");
			sb.append("<PayWay>004</PayWay>"); // 支付方式
			sb.append("<Currency>CNY</Currency>"); // 币种
			sb.append("<SumPayFee>" + insureAmount + "</SumPayFee>"); // 汇总金额
			sb.append("<OperateCode>17</OperateCode>"); // 操作员代码
			sb.append("<OperateDate>" + DateUtils.date2Str(new Date(), "yyyy-MM-dd") + "</OperateDate>"); // 操作日期
			sb.append("<PayOperator>11</PayOperator>"); // 到账确认人代码
			sb.append("<PayDate>" + DateUtils.date2Str(new Date(), "yyyy-MM-dd") + "</PayDate>"); // 到账确认日期
			sb.append("<PaymentCompany>0100000000</PaymentCompany>"); // 收付机构
			sb.append("<BankTradeNo></BankTradeNo>"); // 银行流水号,订单号
			sb.append("<PayeeName>" + userName + "</PayeeName>"); // 付款人姓名
			sb.append("</TradeInfoDto>");
			
			sb.append("<CertiNoList>");
			sb.append("<CertiNoDto>");
			sb.append("<CertiNo>" + applyPolicyNo + "</CertiNo>"); // 投保单号
			sb.append("<Amount>" + insureLimit + "</Amount>"); // 保额
			sb.append("<Premium>" + insureAmount + "</Premium>"); // 保费
			sb.append("</CertiNoDto>");
			sb.append("</CertiNoList>");
			
			sb.append("</Request>");
			sb.append("</B2BRequestXml>");
			
			log.info("调用渤海保险的承保接口请求报文-------------------" + sb.toString());
			
			// 生产加密的KEY
			String key = Global.getBoHaiKey() +sb.toString();
			key = MD5Util.encryptionTo32Bit(key);
			key = key.toUpperCase();

			// 调用承保接口，发送报文数据
			String resultStr = HttpClientUtil.sendPost(Global.getBoHaiIp()+"?key=" + key, sb.toString(),"UTF-8");
					
			log.info("调用承保接口返回报文结果：" + resultStr);
			return resultStr;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("发送渤海保险承保报文接口异常：运单号为"+waybillNumber+",异常信息为："+e.getMessage());
			return null;
		}
	}

	public static String submitInsure(InsureVO ivo ) {
		if(null==ivo){
			throw new RuntimeException("投保参数不能为空");
		}
		return submitInsure(
				ivo.getInsureType(), ivo.getWaybillNumber(),
				ivo.getTarget(), ivo.getCarNum(),
				ivo.getCarVin(), ivo.getCarLoad(),
				ivo.getStartAddress(), ivo.getArriveAddress(),
				ivo.getIdCard(), ivo.getUserName(),
				ivo.getUserSex(), ivo.getBirthday(),
				ivo.getTelephone(), ivo.getInsureAmount(),
				ivo.getInsureLimit(),ivo.getGoodsTypeName(),
				ivo.getGoodsCount(), ivo.getGoodsRemark()
		);
	}

}
