//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.05 at 10:43:32 PM IST 
//


package course_management.com.courses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coursedetails" type="{http://com.course-management/courses}coursedetails"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "coursedetails"
})
@XmlRootElement(name = "GetAllCourseDetailsResponse")
public class GetAllCourseDetailsResponse {

    @XmlElement(required = true)
    protected Coursedetails coursedetails;

    /**
     * Gets the value of the coursedetails property.
     * 
     * @return
     *     possible object is
     *     {@link Coursedetails }
     *     
     */
    public Coursedetails getCoursedetails() {
        return coursedetails;
    }

    /**
     * Sets the value of the coursedetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link Coursedetails }
     *     
     */
    public void setCoursedetails(Coursedetails value) {
        this.coursedetails = value;
    }

}