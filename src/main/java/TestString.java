import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestString {





    public static void sreadStringXml(String xml) {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element rootElt = doc.getRootElement();
        List<Element> childElements = rootElt.elements();
        Map<String,Object> mapEle = new HashMap<String, Object>();
        mapEle = getAllElements(childElements,mapEle);
        String result = mapEle.get("result").toString();
        JSONObject jsonObject= JSONObject.parseObject(result);
        JSONObject resultObj = (JSONObject) jsonObject.get("result");
     /*   Map<String,JSONArray>map = new HashMap<String, JSONArray>();
        for(String str:resultObj.keySet()){
            map.put(str,(JSONArray) resultObj.get(str));
        }*/
        JSONArray jsonArray =(JSONArray) resultObj.get("qtcl");
        List<Qtcl> qtcls = JSONObject.parseArray(jsonArray.toJSONString(), Qtcl.class);
        System.out.println(qtcls);
    }

    private static Map<String, Object> getAllElements(List<Element> childElements,Map<String,Object> mapEle) {
        for (Element ele : childElements) {
            mapEle.put(ele.getName(), ele.getTextTrim());
            if(ele.elements().size()>0){
                mapEle = getAllElements(ele.elements(), mapEle);
            }
        }
        return mapEle;
    }

    public static void main(String[] args) {
        String stringXML = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "      <grequestResponse xmlns=\"http://service.ESB.ep.com\">\n" +
                "         <grequestReturn>\n" +
                "            <esbInfo>\n" +
                "               <attr1/>\n" +
                "               <attr2/>\n" +
                "               <attr3/>\n" +
                "               <instId/>\n" +
                "               <requestTime>2019-11-27 09:06:39.890</requestTime>\n" +
                "               <responseTime>2019-11-27 09:06:39.959</responseTime>\n" +
                "               <returnCode>S001</returnCode>\n" +
                "               <returnMsg>调用成功！</returnMsg>\n" +
                "               <returnStatus>S</returnStatus>\n" +
                "            </esbInfo>\n" +
                "            <resultInfo>\n" +
                "               <result>{\"opflag\":{\"statusMes\":\"查询成功!\",\"status\":\"S\"},\"result\":{\"qtcl\":[{\"sb\":\"JY001\",\"cl\":\"34069\"},{\"sb\":\"JY002\",\"cl\":\"30154\"},{\"sb\":\"JY003\",\"cl\":\"5907\"},{\"sb\":\"JY004\",\"cl\":\"25457\"},{\"sb\":\"JY006\",\"cl\":\"26325\"},{\"sb\":\"JY008\",\"cl\":\"56713\"},{\"sb\":\"JY009\",\"cl\":\"69036\"},{\"sb\":\"JY010\",\"cl\":\"53072\"},{\"sb\":\"LB001\",\"cl\":\"32247.4\"},{\"sb\":\"LB002\",\"cl\":\"51296.9\"},{\"sb\":\"LB003\",\"cl\":\"70732.9\"},{\"sb\":\"LB004\",\"cl\":\"5566\"},{\"sb\":\"LB005\",\"cl\":\"22000.4\"},{\"sb\":\"LB007\",\"cl\":\"7140.3\"},{\"sb\":\"LB008\",\"cl\":\"12137.5\"},{\"sb\":\"LB009\",\"cl\":\"2428\"},{\"sb\":\"PH001\",\"cl\":\"5088\"},{\"sb\":\"TH001\",\"cl\":\"2982\"},{\"sb\":\"XZ001\",\"cl\":\"2683\"},{\"sb\":\"ZZ001\",\"cl\":\"2982\"}],\"sycl\":[{\"gg\":\"Φ16\",\"sb\":\"RL001\",\"cl\":\"5634\"},{\"gg\":\"Φ20\",\"sb\":\"RL001\",\"cl\":\"2454\"},{\"gg\":\"Φ25\",\"sb\":\"RL001\",\"cl\":\"37590\"},{\"gg\":\"Φ16\",\"sb\":\"RL002\",\"cl\":\"1911\"},{\"gg\":\"Φ20\",\"sb\":\"RL002\",\"cl\":\"65872\"},{\"gg\":\"Φ16\",\"sb\":\"RL003\",\"cl\":\"4223\"},{\"gg\":\"Φ20\",\"sb\":\"RL003\",\"cl\":\"2190\"},{\"gg\":\"Φ25\",\"sb\":\"RL003\",\"cl\":\"40020\"},{\"gg\":\"Φ20\",\"sb\":\"RL004\",\"cl\":\"15442\"},{\"gg\":\"Φ16\",\"sb\":\"RL005\",\"cl\":\"2547\"},{\"gg\":\"Φ20\",\"sb\":\"RL005\",\"cl\":\"23998\"},{\"gg\":\"Φ25\",\"sb\":\"RL005\",\"cl\":\"38159\"},{\"gg\":\"Φ12.5\",\"sb\":\"RL006\",\"cl\":\"2672\"},{\"gg\":\"Φ16\",\"sb\":\"RL006\",\"cl\":\"6043\"},{\"gg\":\"Φ20\",\"sb\":\"RL006\",\"cl\":\"44404\"},{\"gg\":\"Φ25\",\"sb\":\"RL099\",\"cl\":\"4700\"}]}}</result>\n" +
                "            </resultInfo>\n" +
                "         </grequestReturn>\n" +
                "      </grequestResponse>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        sreadStringXml(stringXML);

    }
}
