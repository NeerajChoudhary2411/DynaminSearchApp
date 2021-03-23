package in.org.neeraj.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.org.neeraj.model.Insurance;

public class InsurancePlanXlsxView extends AbstractXlsView implements View {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Insurance> list = (List<Insurance>) model.get("list");
		// create sheet
		Sheet sheet = workbook.createSheet("INSURANCE PLAN DETAILS");
		getHead(sheet);
		getBody(sheet, list);

	}

	private void getBody(Sheet sheet, List<Insurance> list) {
		int rownum = 1;
		for (Insurance i : list) {
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(i.getPlanId());
			row.createCell(1).setCellValue(i.getPlanName());
			row.createCell(2).setCellValue(i.getPlanStatus());
			row.createCell(3).setCellValue(i.getStartDate().toString());
			row.createCell(4).setCellValue(i.getEndDate().toString());
			row.createCell(5).setCellValue(i.getHolderName());
			row.createCell(6).setCellValue(i.getHolderSSN());
		}

	}

	private void getHead(Sheet sheet) {
		// creating row by using sheet
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("PLAN_ID");
		row.createCell(1).setCellValue("PLAN_NAME");
		row.createCell(2).setCellValue("PLAN_STATUS");
		row.createCell(3).setCellValue("START_DATE");
		row.createCell(4).setCellValue("END_DATE");
		row.createCell(5).setCellValue("HOLDER_NAME");
		row.createCell(6).setCellValue("HOLDER_SSN");
	}

}
