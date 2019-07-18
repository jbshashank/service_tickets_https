package com.ayushya.spring.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

@Description(value = "Service layer responsible for processing data.")
@Service
public class ExcelService {
	public String ticketNumber;
	public boolean flag = true;
	public int localTickNum;
	@Autowired
	TicketService ticketService;
	@Autowired
	private NextSequenceService nextSequenceService;
//    /**
//     * Method for reading from specific excel file when we know types and number of cells.
//     *
//     * @return list of mapped objects
//     * @throws IOException - throws IO exception.
//     */
//    public List<TicketDTO> readFromExcelWithKnownObject() throws IOException
//    {
//        // get file that needs to be mapped into object.
//        Resource resource = new ClassPathResource("documents/sample.xlsx");
//        FileInputStream inputStream = new FileInputStream(resource.getFile());
//
//        // get workbook and sheet
//        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        List<TicketDTO> ticketDTOList = new ArrayList<>();
//
//        // iterate through rows
//        Iterator<Row> iterator = sheet.iterator();
//        while (iterator.hasNext())
//        {
//            Row currentRow = iterator.next();
//
//            // skip heading row.
//            if (currentRow.getRowNum() == 0) {
//                continue;
//            }
//
//            // mapped to example object.
//            TicketDTO ticketDTO = new TicketDTO();
//            ticketDTO.setTicketId(currentRow.getCell(0).getStringCellValue());
//            ticketDTO.setCustomer(currentRow.getCell(1).getStringCellValue());
//            ticketDTO.setBrand(currentRow.getCell(2).getDateCellValue().toString());
//            ticketDTO.setCategory(currentRow.getCell(3).getStringCellValue());
//            ticketDTO.setModel(currentRow.getCell(4).getStringCellValue());
//
//            ticketDTOList.add(ticketDTO);
//        }
//        return ticketDTOList;
//    }
    
    /**
     * Method for reading from specific excel file when we know types and number of cells.
     *
     * @return list of mapped objects
     * @throws IOException - throws IO exception.
     * @throws ParseException 
     */
    public List<Tickets> readFromExcelWithKnownObject(MultipartFile multipartFile) throws IOException, ParseException
    {
        // get file that needs to be mapped into object.
    	    InputStream inputStream = new ByteArrayInputStream(multipartFile.getBytes());

        // get workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<Tickets> ticketDTOList = new ArrayList<>();

        // iterate through rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext())
        {
            Row currentRow = iterator.next();  
            // skip heading row.
            if (currentRow.getRowNum() == 0) {
                continue;
            }


    // mapped to example object.
    Tickets ticketDTO = new Tickets();
//    ticketDTO.setTicketId(currentRow.getCell(0).getStringCellValue());
    if(getCellValueAsString(currentRow.getCell(0))!=null) {
	ticketDTO.set_id(nextSequenceService.getNextSequence("customSequences",new SimpleDateFormat("ddMMyy").format(new Date())));
	ticketDTO.setCall_type(getCellValueAsString(currentRow.getCell(1)));
	ticketDTO.setName(getCellValueAsString(currentRow.getCell(2)));
	ticketDTO.setAddress_1(getCellValueAsString(currentRow.getCell(3)));
	ticketDTO.setAddress_2(getCellValueAsString(currentRow.getCell(4)));
	ticketDTO.setStreet(getCellValueAsString(currentRow.getCell(5)));
	ticketDTO.setCity(getCellValueAsString(currentRow.getCell(6)));
	ticketDTO.setState(getCellValueAsString(currentRow.getCell(7)));
	ticketDTO.setPin_code(getCellValueAsString(currentRow.getCell(8)));
	ticketDTO.setTicket_status("reported");
	Technician technician = ticketService.getEmployeeData(ticketDTO);
	if(technician!=null) {
	ticketDTO.setTech_name(technician.getSeName());
	ticketDTO.setTechnicianUniqueId(technician.getSeUniqueId());
	if(ticketDTO.getTech_name()!=null)ticketDTO.setTicket_status("open");
	}
	
	ticketDTO.setMobile_number_1(getCellValueAsString(currentRow.getCell(9)));
	ticketDTO.setMobile_number_2(getCellValueAsString(currentRow.getCell(10)));
	ticketDTO.setEmail_id(getCellValueAsString(currentRow.getCell(11)));
	ticketDTO.setBrand(getCellValueAsString(currentRow.getCell(12)));
	ticketDTO.setProduct_category(getCellValueAsString(currentRow.getCell(13)));
    ticketDTO.setProduct_sub_category(getCellValueAsString(currentRow.getCell(14)));
	ticketDTO.setModel_name(getCellValueAsString(currentRow.getCell(15)));
	ticketDTO.setSerial_number(getCellValueAsString(currentRow.getCell(16)));
	ticketDTO.setIw(getCellValueAsString(currentRow.getCell(17)));
	String visitDate = getCellValueAsString(currentRow.getCell(18));
//	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
//	String strDate = dateFormat.format(visitDate1);
	String visitTime = getCellValueAsString(currentRow.getCell(19));
//	visitDate = "12-12-2019";
//	visitTime = "1005AM";
	// Conversion
	Date sourceDate = new SimpleDateFormat("dd.MM.yy:HHmm").parse(visitDate+":"+visitTime.substring(0,4));
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	sdf.setTimeZone(TimeZone.getTimeZone("IST"));
	ticketDTO.setVisit_time(sourceDate);
	ticketDTO.setRemarks(getCellValueAsString(currentRow.getCell(20)));
	ticketDTO.setDate_of_post(new SimpleDateFormat("ddMMyyhhmmss").format(new Date()));
	ticketDTO.setInvoice_number(getCellValueAsString(currentRow.getCell(22)));
	ticketDTO.setDealer_name(getCellValueAsString(currentRow.getCell(23)));
	ticketDTO.setTicket_status("Open");

            ticketDTOList.add(ticketDTO);
    }}
        return ticketDTOList;
    }
    
    public static String getCellValueAsString(Cell cell) {
        String strCellValue = null;
        if (cell != null) {
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                strCellValue = cell.toString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "dd.MM.yy");
                    strCellValue = dateFormat.format(cell.getDateCellValue());
                } else {
                    Double value = cell.getNumericCellValue();
                    Long longValue = value.longValue();
                    strCellValue = new String(longValue.toString());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                strCellValue = new String(new Boolean(
                        cell.getBooleanCellValue()).toString());
                break;
            case Cell.CELL_TYPE_BLANK:
                strCellValue = null;
                break;
            }
        }
        return strCellValue;
    }


}
