package io.mosip.authentication.fw.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import io.mosip.authentication.fw.dto.TokenIdDto;
import io.mosip.testrunner.MosipTestRunner;

/**
 * The class perform picking up UIN,VID,TokenID,PartnerID,LicenseKey,StaticPin
 * 
 * @author Vignesh
 *
 */
public class RunConfigUtil {
	
	private static final Logger runConfidUtilLogger = Logger.getLogger(RunConfigUtil.class);
	private static final String idaEnvConfigPath="/ida/TestData/RunConfig/envRunConfig.properties";
	public static final String resourceFolderName="MosipTemporaryTestResource";
	
	/**
	 * The method get UIN property file path
	 * 
	 * @return string, property file path
	 */
	public static String getUinPropertyPath() {
		return RunConfigUtil.objRunConfig.getModuleFolderName()+File.separator + RunConfigUtil.objRunConfig.getTestDataFolderName() + "/RunConfig/uin.properties";
	}
	/**
	 * The method get static pin UIN property path
	 * 
	 * @return string, property file path
	 */
	public static String getStaticPinUinPropertyPath() {
		return RunConfigUtil.objRunConfig.getModuleFolderName()+File.separator + RunConfigUtil.objRunConfig.getTestDataFolderName() + "/RunConfig/uinStaticPin.properties";
	}
	/**
	 * The method return VID property file path
	 * 
	 * @return string, property file path
	 */
	public static String getVidPropertyPath() {
		return RunConfigUtil.objRunConfig.getModuleFolderName()+File.separator + RunConfigUtil.objRunConfig.getTestDataFolderName() + "/RunConfig/vid.properties";
	}
	/**
	 * The method get static pin VID property file path
	 * 
	 * @return string, property file path
	 */
	public static String getStaticPinVidPropertyPath() {
		return RunConfigUtil.objRunConfig.getModuleFolderName()+File.separator + RunConfigUtil.objRunConfig.getTestDataFolderName() + "/RunConfig/vidStaticPin.properties";
	}
	/**
	 * The method get tokenId property file path
	 * 
	 * @return string, property file path
	 */
	public static String getTokenIdPropertyPath() {
		return RunConfigUtil.objRunConfig.getModuleFolderName()+File.separator + RunConfigUtil.objRunConfig.getTestDataFolderName() + "/RunConfig/static-tokenId.properties";
	}
	/**
	 * The method get partnerID and Misp License key value property file path
	 * 
	 * @return string, property file path
	 */
	public static String getPartnerIDMispLKPropertyPath() {
		return RunConfigUtil.objRunConfig.getModuleFolderName()+File.separator + RunConfigUtil.objRunConfig.getTestDataFolderName() + "/RunConfig/parter-license-id.properties";
	}
	/**
	 * The method get partnerID and License key value for the key
	 * 
	 * @param key
	 * @return string, value of partner ID and License key
	 */
	public static String getPartnerIDMispLKValue(String key) {
		return AuthTestsUtil.getPropertyFromRelativeFilePath(getPartnerIDMispLKPropertyPath()).get(key).toString();
	}
	/**
	 * The method get RID property file path
	 * 
	 * @return string, property file path
	 */
	public static String getRidPropertyPath() {
		return RunConfigUtil.objRunConfig.getModuleFolderName()+File.separator + RunConfigUtil.objRunConfig.getTestDataFolderName() + "/RunConfig/rid.properties";
	}
	/**
	 * The method get token ID for UIN and PartnerID
	 * 
	 * @param uin
	 * @param partnerID
	 * @return tokenID
	 */
	public static String getTokenId(String uin, String partnerID) {		
		TokenIDGenerator tokenGenrator = new TokenIDGenerator();
		String token = tokenGenrator.generateTokenID(uin, RunConfigUtil.objRunConfig.getAuthPartnerID(), RunConfigUtil.objRunConfig.getUinSalt(), RunConfigUtil.objRunConfig.getPartnerCodeSalt(), RunConfigUtil.objRunConfig.getTokenIDLength());
		return tokenGenrator.generateTokenID(token, partnerID, RunConfigUtil.objRunConfig.getUinSalt(), RunConfigUtil.objRunConfig.getPartnerCodeSalt(), RunConfigUtil.objRunConfig.getTokenIDLength());
	}
	
	/**
	 * The methof get tokenID property value
	 * 
	 * @param path
	 */
	public static void getTokenIdPropertyValue(String path) {
		Properties prop = AuthTestsUtil.getPropertyFromRelativeFilePath(path);
		Map<String, String> map = new HashMap<>();
		for (String key : prop.stringPropertyNames()) {
			String value = prop.getProperty(key);
			map.put(key, value);
		}
		TokenIdDto.setTokenId(map);
	}
	
	public static RunConfig objRunConfig;

	/**
	 * The method get object of runtime module config
	 * 
	 * @param moduleObject
	 */
	public static void getRunConfigObject(String module) {
			objRunConfig = new IdaRunConfig();
	}
	
	/**
	 * The method get environment
	 * 
	 * @return environment such as qa or int or dev or dev-int
	 */
	public static String getRunEvironment() {
		return System.getProperty("env.user");
	}
	
	
	/**
	 * Get test type of execution such as smoke, regression or funtional etc
	 * 
	 * @return testLevel or testType
	 */
	public static String getTestLevel() {
		return System.getProperty("env.testLevel");
	}
	
	public static String getLinuxMavenPath() {
		return AuthTestsUtil.getPropertyFromFilePath(new File(RunConfigUtil.getResourcePath()+idaEnvConfigPath).getAbsolutePath()).get("linuxMavenPath").toString();
	}
	
	public static String getGlobalResourcePath() {
		return MosipTestRunner.getGlobalResourcePath();
	}
	
	public static String getResourcePath() {
		return getGlobalResourcePath()+File.separator+resourceFolderName+File.separator;
	}
	
	public static String getdemoAppVersion() {
		return AuthTestsUtil.getPropertyFromFilePath(new File(RunConfigUtil.getResourcePath()+idaEnvConfigPath).getAbsolutePath()).get("demoAppVersion").toString();
	}
	
	public static String getAuthSeriveName() {
		return AuthTestsUtil.getPropertyFromFilePath(new File(RunConfigUtil.getResourcePath()+idaEnvConfigPath).getAbsolutePath()).get("auth.service.name").toString();
	}
	
	public static String getOtpGenerateSeriveName() {
		return AuthTestsUtil.getPropertyFromFilePath(new File(RunConfigUtil.getResourcePath()+idaEnvConfigPath).getAbsolutePath()).get("auth.otp.generate.service.name").toString();
	}
	
	public static String getInternalAuthSeriveName() {
		return AuthTestsUtil.getPropertyFromFilePath(new File(RunConfigUtil.getResourcePath()+idaEnvConfigPath).getAbsolutePath()).get("auth.internal.service.name").toString();
	}
	
	public static String getKycAuthSeriveName() {
		return AuthTestsUtil.getPropertyFromFilePath(new File(RunConfigUtil.getResourcePath()+idaEnvConfigPath).getAbsolutePath()).get("auth.kyc.service.name").toString();
	}
	
	public static String getVidUsageCount() {
		return AuthTestsUtil.getPropertyFromFilePath(new File(RunConfigUtil.getResourcePath()+idaEnvConfigPath).getAbsolutePath()).get("vid.temporary.usageTime").toString();
	}
	
	public static String getBioTestDataPath() {
		return RunConfigUtil.getResourcePath()+RunConfigUtil.objRunConfig.getModuleFolderName()+File.separator + RunConfigUtil.objRunConfig.getTestDataFolderName() + "/RunConfig/biometricData.yml";
	}
	
	public static String getAuthTypeStatusPath() {
		return new File(RunConfigUtil.getResourcePath() + RunConfigUtil.objRunConfig.getModuleFolderName() + File.separator + RunConfigUtil.objRunConfig.getTestDataFolderName()
		+ "/RunConfig/authTypeStatus.properties").getAbsolutePath();
	}
	
	public static String getBioValueEncryptionTemplatePath() {
		return new File(RunConfigUtil.getResourcePath()+"ida/TestData/Bio/bioValueEncryptionTemplate.json").getAbsolutePath();
	}
	public static String getInternalBioValueEncryptionTemplatePath() {
		return new File(RunConfigUtil.getResourcePath()+"ida/TestData/InternalAuth/Bio/bioValueEncryptionTemplate.json").getAbsolutePath();
	}
}
