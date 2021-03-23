package in.org.neeraj.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.org.neeraj.model.Insurance;

public class InsurancePlanPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse respons) throws Exception {

		@SuppressWarnings("unchecked")
		List<Insurance> list = (List<Insurance>) model.get("list");

		Font f1 = new Font(Font.COURIER, 20f, Font.BOLD, Color.BLUE);
		Paragraph title = new Paragraph("INSURANCE PLAN DETAILS", f1);
		title.setAlignment(Element.ALIGN_CENTER);

		document.add(title);
		PdfPTable table = new PdfPTable(7);
		table.setSpacingAfter(2.5f);
		table.setSpacingBefore(3.5f);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.0f, 1.9f, 2.3f, 2.0f, 2.3f, 2.1f, 1.7f });

		Font f2 = new Font(Font.HELVETICA, 11f, Font.BOLD, Color.BLACK);

		table.addCell(new Phrase("P_ID", f2));
		table.addCell(new Phrase("PLAN_NAME", f2));
		table.addCell(new Phrase("PLAN_STATUS", f2));
		table.addCell(new Phrase("START_DATE", f2));
		table.addCell(new Phrase("HOLDER_NAME", f2));
		table.addCell(new Phrase("HOLDER_SSN", f2));
		table.addCell(new Phrase("END_DATE", f2));

		Font f3 = new Font(Font.ITALIC, 10f, Font.COURIER, Color.BLACK);

		for (Insurance i : list) {
			table.addCell(new Phrase(String.valueOf(i.getPlanId()), f3));
			table.addCell(new Phrase(i.getPlanName(), f3));
			table.addCell(new Phrase(i.getPlanStatus(), f3));
			table.addCell(new Phrase(String.valueOf(i.getStartDate()), f3));
			table.addCell(new Phrase(i.getHolderName(), f3));
			table.addCell(new Phrase(String.valueOf(i.getHolderSSN()), f3));
			table.addCell(new Phrase(String.valueOf(i.getEndDate()), f3));
		}
		document.add(table);
	}

}
