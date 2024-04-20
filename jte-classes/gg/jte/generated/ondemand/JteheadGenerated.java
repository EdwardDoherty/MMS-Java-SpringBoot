package gg.jte.generated.ondemand;
import com.MMS.MMS.dto.UserDTO;
public final class JteheadGenerated {
	public static final String JTE_NAME = "head.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,6,6,6,6,12,12,12,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title) {
		jteOutput.writeContent("\r\n<head>\r\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\r\n    <link href=\"/css/main.css\" rel=\"stylesheet\" />\r\n    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n    <link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap\" rel=\"stylesheet\">\r\n    <script src=\"https://kit.fontawesome.com/86a01f560a.js\" crossorigin=\"anonymous\"></script>\r\n</head>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.getOrDefault("title", "MMS - App");
		render(jteOutput, jteHtmlInterceptor, title);
	}
}
