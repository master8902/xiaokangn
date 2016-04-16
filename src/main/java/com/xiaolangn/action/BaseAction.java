package com.xiaolangn.action;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.xiaolangn.bean.User;
import com.xiaolangn.service.IUserService;

public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware, ServletContextAware, Preparable {

	@Resource
	IUserService userService;


	UserContext context = new UserContext();

	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext servletContext;
	protected String errorContent = "";
	protected String errorTitle = "";
	protected static String CLOSE = "close";
	protected static String BACK = "back";
	protected String errorAction = BACK;
	protected String ryingoaFileDir;
	protected String productSupportDir;
	protected String productFilesDir;
	protected String productPerformanceDir;
	protected String productApprovalDocumentDir;
	protected String adminFilesDir;
	protected String productModelDir;
	protected String bluePaperDir;
	protected String valid_day;
	protected String valid_day_project;
	protected static final String AJAX_SUCCESS = "success";
	protected static final String AJAX_FAILED = "failed";
	protected static final String AJAX_ERROR = "error";
	protected Map<String, Object> ajax_return_values = new HashMap<String, Object>();
	private static final long serialVersionUID = 218713868451271466L;

	/**
	 *
	 *
	 * @param total
	 *
	 * @param limit
	 *
	 * @return
	 */
	public static Integer calcPage(Integer total, Integer limit) {
		return total == 0 ? 1 : (total / limit + ((total % limit) > 0 ? 1 : 0));
	}

	public static String GBK2UTF8(String value) {
		try {
			if (value == null) {
				return "";
			} else {
				value = new String(value.getBytes("ISO-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}



	
	public List<User> getUserByRole(Integer role) {

		return null;
	}

	public List<User> getUserByPerm(Integer moduleId, Integer authId) {

		return null;
	}

	public String getSystemName() {
		return "锐英OA系统";
	}

	
	public boolean isLogedin() {
		return context.isLogedin();
	}

	public User getLoginUser() {
		Integer userId = context.getLoginUserId();
		return userService.getUserById(userId);
	}

	public String getCurrentNamespace() {
		return ServletActionContext.getActionMapping().getNamespace();
	}



	public String getCurrentAction() {
		return ServletActionContext.getActionMapping().getName();
	}



	public String getErrorContent() {
		return errorContent;
	}

	public void setErrorContent(String errorContent) {
		this.errorContent = errorContent;
	}

	public String getErrorTitle() {
		return errorTitle;
	}

	public void setErrorTitle(String errorTitle) {
		this.errorTitle = errorTitle;
	}

	public String getErrorAction() {
		return errorAction;
	}

	public void setErrorAction(String errorAction) {
		this.errorAction = errorAction;
	}

	/**
	 * BasePath
	 *
	 * @return
	 */
	public String getBasePath() {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName();
		int port = request.getServerPort();
		if (port != 80 && port != 443) {
			basePath = basePath + ":" + request.getServerPort() + path + "/";
		} else {
			basePath = basePath + path + "/";
		}
		return basePath;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		session = map;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		context.setSession(request.getSession(false));
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		this.response = response;
	}

	public boolean isGetMethod() {
		return this.request.getMethod().equals("GET");
	}

	public boolean isPostMethod() {
		return this.request.getMethod().equals("POST");
	}

	public boolean isBelongsToOrg(int orgId) {
		String org_ids = (String) session.get("org_id");
		for (String id : org_ids.split(",")) {
			if (id.equals(String.valueOf(orgId))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;

	}

	@Override
	public void prepare() throws Exception {
		String osname = System.getProperty("os.name").toLowerCase();
		if (osname.contains("windows")) {
			ryingoaFileDir = this.servletContext.getInitParameter("filePathForWindows");
		} else {
			ryingoaFileDir = this.servletContext.getInitParameter("filePathForLinux");
		}
		valid_day = this.servletContext.getInitParameter("docShareDeadline");
		valid_day_project = this.servletContext.getInitParameter("projectShareDeadline");
		productSupportDir = ryingoaFileDir + "/" + "product_support_documents";
		productFilesDir = ryingoaFileDir + "/" + "product_file_documents";
		productModelDir = ryingoaFileDir + "/" + "product_model_documents";
		productPerformanceDir = ryingoaFileDir + "/" + "product_performance_documents";
		productApprovalDocumentDir = ryingoaFileDir + "/" + "product_approval_documents";
		adminFilesDir = ryingoaFileDir + "/" + "admin_file_documents";
		bluePaperDir = ryingoaFileDir + "/" + "blue_paper_documents";
		File file = new File(productSupportDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		file = new File(productFilesDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		file = new File(productModelDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		file = new File(productPerformanceDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		file = new File(productApprovalDocumentDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		file = new File(adminFilesDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		file = new File(bluePaperDir);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	protected void ajaxPrint(String content) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");// 防止弹出的信息出现乱码

		try {
			PrintWriter writer = response.getWriter();
			writer.print(content);
			writer.close();

			System.out.println("content = " + content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected boolean hasCheckToken() {
		String sessionToken = (String) request.getSession().getAttribute("struts.tokens.token");
		String token = this.request.getParameter("token");
		return (sessionToken != null && sessionToken.equals(token));
	}
}
