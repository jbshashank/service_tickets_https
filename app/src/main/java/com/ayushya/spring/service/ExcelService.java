package com.ayushya.spring.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ayushya.spring.bean.tickets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Description(value = "Service layer responsible for processing data.")
@Service
public class ExcelService {
	public String ticketNumber;
	public boolean flag = true;
	public int localTickNum;
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
     */
    public List<tickets> readFromExcelWithKnownObject(MultipartFile multipartFile) throws IOException
    {
        // get file that needs to be mapped into object.
    	    InputStream inputStream = new ByteArrayInputStream(multipartFile.getBytes());

        // get workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<tickets> ticketDTOList = new ArrayList<>();

        // iterate through rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext())
        {
            Row currentRow = iterator.next();  
            System.out.println(currentRow.getCell(0).getStringCellValue());
            // skip heading row.
            if (currentRow.getRowNum() == 0) {
                continue;
            }
            Double val = (currentRow.getCell(7).getNumericCellValue());
            String val1 = String.format("%.0f", val);
            System.out.println(val1);

    // mapped to example object.
    tickets ticketDTO = new tickets();
//    ticketDTO.setTicketId(currentRow.getCell(0).getStringCellValue());
    
	ticketDTO.set_id(nextSequenceService.getNextSequence("customSequences",new SimpleDateFormat("ddMMyy").format(new Date())));
	ticketDTO.setCall_type(currentRow.getCell(0).getStringCellValue());
	ticketDTO.setName(currentRow.getCell(1).getStringCellValue());
	ticketDTO.setAddress_1(currentRow.getCell(2).getStringCellValue());
	ticketDTO.setAddress_2(currentRow.getCell(3).getStringCellValue());
	ticketDTO.setStreet(currentRow.getCell(4).getStringCellValue());
	ticketDTO.setCity(currentRow.getCell(5).getStringCellValue());
	ticketDTO.setState(currentRow.getCell(6).getStringCellValue());
	ticketDTO.setPin_code(String.format("%.0f", currentRow.getCell(7).getNumericCellValue()));
	ticketDTO.setTech_name(null);
	ticketDTO.setMobile_number_1(String.format("%.0f",currentRow.getCell(9).getNumericCellValue()));
	ticketDTO.setMobile_number_2(String.format("%.0f",currentRow.getCell(10).getNumericCellValue()));
	ticketDTO.setEmail_id(currentRow.getCell(11).getStringCellValue());
	ticketDTO.setBrand(currentRow.getCell(12).getStringCellValue());
	ticketDTO.setProduct_category(currentRow.getCell(13).getStringCellValue());
	ticketDTO.setModel_name(currentRow.getCell(14).getStringCellValue());
	ticketDTO.setSerial_number(currentRow.getCell(15).getStringCellValue());
	ticketDTO.setIw(currentRow.getCell(16).getStringCellValue());
	//ticketDTO.setVisit_date(new SimpleDateFormat("ddMMyyhhmmss").format(new Date()));
	//ticketDTO.setTime_of_visit(new SimpleDateFormat("ddMMyyhhmmss").format(new Date()));
	ticketDTO.setRemarks(currentRow.getCell(19).getStringCellValue());
	ticketDTO.setDate_of_post(new SimpleDateFormat("ddMMyyhhmmss").format(new Date()));
	ticketDTO.setDealer_name(currentRow.getCell(22).getStringCellValue());

            ticketDTOList.add(ticketDTO);
        }
        return ticketDTOList;
    }


}
