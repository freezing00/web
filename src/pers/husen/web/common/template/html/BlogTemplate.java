package pers.husen.web.common.template.html;

import java.text.SimpleDateFormat;

import pers.husen.web.bean.vo.BlogArticleVo;

/**
 *
 *
 * @author 何明胜
 *
 * 2017年10月18日
 */
public class BlogTemplate {
	/**
	 * 单独的js和css
	 * @return
	 */
	public static String customizeHeader() {
		String cHeader = "	<!-- editor.md -->\r\n" + 
				"	<link rel=\"stylesheet\" href=\"/plugins/editormd/css/editormd.preview.min.css\" />\r\n" + 
				"	<link rel=\"stylesheet\" href=\"/plugins/editormd/css/editormd.min.css\" />\r\n" + 
				"	\r\n" + 
				"	<!-- editor.md -->\r\n" + 
				"	<script type=\"text/javascript\" src=\"/plugins/editormd/lib/marked.min.js\"></script>\r\n" + 
				"	<script type=\"text/javascript\" src=\"/plugins/editormd/lib/prettify.min.js\"></script>\r\n" + 
				"	<script type=\"text/javascript\" src=\"/plugins/editormd/js/editormd.min.js\"></script>\r\n" + 
				"	\r\n" + 
				"	<!-- 自定义CSS -->\r\n" + 
				"	<link rel=\"stylesheet\" href=\"/css/article/article.css\">\r\n"+
				"	<!-- 自定义脚本 -->\r\n" + 
				"	<script type=\"text/javascript\" src=\"/js/article/article-markdown.js\"></script>";
		
		return cHeader;
	}
	
	/**
	 * 查看博客的html body
	 * @return
	 */
	public static String detailBlogBody(BlogArticleVo bVo, boolean isSuperAdmin) {
		String body = "<div id=\"fh5co-page\">\r\n" + 
				"	<a href=\"#\" class=\"js-fh5co-nav-toggle fh5co-nav-toggle\"><i></i></a>\r\n" + 
				"	<a id=\"menuBarNo\" style=\"display: none;\">1</a>\r\n" + 
					GenericTemplate.loginAndRegister()+
				"	\r\n" + 
				"	<div id=\"fh5co-main\">\r\n" + 
					GenericTemplate.topFixedBar() +
				"		<div id=\"list_blog\" class=\"fh5co-post\"> \r\n" + 
				"			<!-- js脚本动态添加内容 -->" +
				"			\r\n" +
				"			<div class=\"fh5co-entry\" id=\"content\">" +
				"				<div>" +
				"					<h2 style=\"text-align: center;\"><input type=\"text\" style=\"display:none\" value="+ bVo.getBlogId() + "\"  />"+
				"						<a href=#>" + bVo.getBlogTitle() + "</a>"+
				"					</h2>"+
				"					<span class=\"fh5co-post-date\">" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(bVo.getBlogDate()) + "</span>"+
				"					<span class=\"fh5co-post-date\">作者:" + bVo.getBlogAuthor() + "</span>"+
				"					<span class=\"fh5co-post-date\">浏览" + bVo.getBlogRead() + "次</span>";
		
		if(isSuperAdmin) {
			body += "<a href=\"/upload/editor_article.jsp?blogId=" + bVo.getBlogId() + "\" target=\"_blank\" role=\"button\" class=\"btn btn-default btn-sm\">编辑</a>"; 
		}
		
		body += 
				"					<p>" + bVo.getBlogHtmlContent() +"</p>" +
				"				</div>" +
				"			</div>" +
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"</div>";
		
		return body;
	}
}