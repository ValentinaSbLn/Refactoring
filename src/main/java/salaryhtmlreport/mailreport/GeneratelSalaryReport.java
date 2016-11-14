package salaryhtmlreport.mailreport;

import salaryhtmlreport.mailreport.Empolyee;

import java.util.List;

public class GeneratelSalaryReport {

    public String generateHtmlSalaryReport(List<Empolyee> empList) {
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        for (Empolyee empolyee : empList) {
            resultingHtml.append("<tr>");
            resultingHtml.append("<td>").append(empolyee.getName()).append("</td>");
            resultingHtml.append("<td>").append(empolyee.getSalary()).append("</td>");
            resultingHtml.append("</tr>");
            totals += empolyee.getSalary();
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");
        return resultingHtml.toString();
    }
}
