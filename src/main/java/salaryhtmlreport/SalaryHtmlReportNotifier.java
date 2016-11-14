package salaryhtmlreport;

import salaryhtmlreport.mailreport.Empolyee;
import salaryhtmlreport.mailreport.GeneratelSalaryReport;
import salaryhtmlreport.mailreport.MailSender;
import salaryhtmlreport.mailreport.QuerySalaryReader;

import javax.mail.MessagingException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class SalaryHtmlReportNotifier {
    private final QuerySalaryReader querySalaryReader;
    private final MailSender sender;

    public SalaryHtmlReportNotifier(Connection databaseConnection, String messageHost) {
        querySalaryReader = new QuerySalaryReader(databaseConnection);
        sender = new MailSender(messageHost);
    }

    public void generateAndSendHtmlSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) {
        try {
           List<Empolyee> empolyees = querySalaryReader.readQuery(departmentId, dateFrom, dateTo);
           String message = new GeneratelSalaryReport().generateHtmlSalaryReport(empolyees);
            sender.sendMessage(recipients, message);
        } catch (MessagingException e) {
            System.out.println("Сообщение отправить не удалось");
            e.printStackTrace();
        }
    }
}
