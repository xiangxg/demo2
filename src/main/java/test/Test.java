package test;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;



public class Test {
    private static int numA = 1;
    private static int numB = 2;
    private static int state = 1;


    public static void main(String[] args){
        Object o = new Object();
        new Thread(()->{
            while (numA <100){
                synchronized (o){
                    if (state != 1){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(numA);
                    numA+=2;
                    state = 2;
                    o.notifyAll();
                }

            }
        }).start();

        new Thread(()->{
            while (numB <=100){
                synchronized (o){
                    if (state != 2){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(numB);
                    numB+=2;
                    state = 1;
                    o.notifyAll();
                }

            }
        }).start();
    }
    @org.junit.Test
    public void test(){
        String str = "{\"auditBatchNo\": \"d7fa8197-9f07-464c-9d17-14df5c5273fe\",\"auditReportExcel\": [{\"url\":\"http://ps.szfetsc.com/magicflu/service/s/00315d16-2cb0-4a29-85c8-fe5cfb4f248f/forms/9a0f0b9d-5f18-40d8-99e6-4163914cfb93/records/128/pingshenqingdanhebaogao/attachments/download/d40d57fa-d56f-4e9a-b140-e7ee07a0f3c4\"},{\"url\":\"http://ps.szfetsc.com/magicflu/service/s/00315d16-2cb0-4a29-85c8-fe5cfb4f248f/forms/9a0f0b9d-5f18-40d8-99e6-4163914cfb93/records/128/pingshenqingdanhebaogao/attachments/download/6a4c49e4-e4b1-44f0-b21a-9e354f15fa54\"}],\"auditReportPDF\": [{\"url\":\"http://ps.szfetsc.com/magicflu/service/s/00315d16-2cb0-4a29-85c8-fe5cfb4f248f/forms/9a0f0b9d-5f18-40d8-99e6-4163914cfb93/records/128/pingshenpingfenbiaocundang/attachments/download/f3c365e4-c23f-448c-aafc-55b3601dcd9a\"}],\"expectExpertExcel\": [{\"url\":\"http://ps.szfetsc.com\"}],\"realExpertExcel\":[{\"url\":\"http://ps.szfetsc.com\"}],\"audits\": [{\"auditComment\": \"该项目主要开展新能源电动汽车四合一集成控制器的研发，具有一定的市场前景和社会效益，但是项目建设内容缺乏技术先进性，团队研发基础偏弱，知识产权等成果有待加强，单位运营和财务状况较差。  经专家组评审，建议评审不通过。\",\"companyName\": \"深圳熙斯特新能源技术有限公司\",\"projectName\": \"新能源电动汽车四合一集成控制器项目\",\"projectSerialNo\": \"S02912221906270008\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com/magicflu/service/s/00315d16-2cb0-4a29-85c8-fe5cfb4f248f/forms/60698369-6897-4410-b930-57de505cef3a/records/4981/cundangwenjian/attachments/download/827a7497-c5ed-401a-8493-c066261e6645\"}],\"techScore\": \"45.3\",\"totalScore\": \"58.5\"},{\"auditComment\": \"该项目主要开展分布式单相光伏储能逆变器的研究开发与应用，具有一定的市场前景和社会效益，但是项目建设内容先进性不足，且研发团队技术基础稍弱，单位运营和财务状况较差。 经专家组评审，建议评审通过。\",\"companyName\": \"深圳市首航新能源有限公司\",\"projectName\": \"分布式单相光伏储能逆变器的研究开发与应用\",\"projectSerialNo\": \"S02912221906260005\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"56.82\",\"totalScore\": \"66.22\"},{\"auditComment\": \"该项目主要开展360KW直流12枪环形柔性充电堆的研发，具有一定的市场前景和社会效益，项目建设内容合理，技术先进性强，项目团队具有较好的研发基础，知识产权等成果较好，单位运营和财务状况良好。  经专家组评审，建议评审通过。\",\"companyName\": \"深圳市盛弘电气股份有限公司\",\"projectName\": \"360KW直流12枪环形柔性充电堆\",\"projectSerialNo\": \"S0291222190627000V\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"66.822\",\"totalScore\": \"82.422\"},{\"auditComment\": \"该项目主要开展面向新能源汽车的环保型高倍率电池的研发和生产，具有一定的市场前景和社会效益。但是该项目建设内容不明确，缺乏科学性和可行性，且项目研发团队基础较弱，知识产权积累主要以软著为主。  经专家组评审，建议评审通过。\",\"companyName\": \"深圳安凯利电池有限公司\",\"projectName\": \"面向新能源汽车的环保型高倍率电池的研发及产业链关键环节提升项目\",\"projectSerialNo\": \"S0291222190627000K\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"58.098\",\"totalScore\": \"70.698\"},{\"auditComment\": \"该项目主要开展磷酸铁锂宽温度范围动力电池的研发和生产，市场前景和社会效益较好，项目建设内容合理，项目团队具有较好的研发基础，单位运营和财务状况良好，但是从佐证材料看，项目执行期内，知识产权等成果有待加强。  经专家组评审，建议评审通过。\",\"companyName\": \"深圳市电科电源股份有限公司\",\"projectName\": \"磷酸铁锂宽温度范围动力电池产业链关键环节提升项目\",\"projectSerialNo\": \"S0291222190627000S\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"60.478\",\"totalScore\": \"76.478\"},{\"auditComment\": \"该项目开展智能高效超大功率柔性充电关键技术开发及生产，具有较好的市场前景。研发基础和研发团队较好，技术先进，建设内容与方案合理，取得了较好的经济与社会效益和技术成果。 经专家组评审，建议评审通过。\",\"companyName\": \"深圳市金威源科技股份有限公司\",\"projectName\": \"智能高效超大功率柔性充电关键技术研发及产业化\",\"projectSerialNo\": \"S0291222190627001N\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"68.368\",\"totalScore\": \"81.568\"},{\"auditComment\": \"该项目主要开展超高电压锂离子聚合物电池平台的应用研发，市场前景和社会效益好，项目建设内容合理可行，项目团队具有较好的研发基础，知识产权等成果较好，单位运营和财务状况较好。 经专家组评审，建议评审通过。\",\"companyName\": \"曙鹏科技（深圳）有限公司\",\"projectName\": \"超高电压锂离子聚合物电池平台应用研发产业化项目\",\"projectSerialNo\": \"S0291222190627000P\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"66.31\",\"totalScore\": \"82.51\"},{\"auditComment\": \"该项目主要开展新能源汽车充电桩智能运维平台研发，具有一定的市场前景和社会效益，但是该项目研发团队基础一般，项目建设内容缺乏合理性，单位运营和财务状况较差，不具备执行该项目的资金基础。  经专家组评审，建议评审不通过。\",\"companyName\": \"充之鸟（深圳）新能源科技有限公司\",\"projectName\": \"新能源汽车充电桩智能运维平台关键环节提升项目\",\"projectSerialNo\": \"S0291222190627000D\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"45.93\",\"totalScore\": \"53.53\"},{\"auditComment\": \"该项目主要开展新一代三相组串式光伏逆变器的相关研发和生产，市场前景和社会效益较好，项目建设内容合理，技术先进，项目拥有的知识产权等成果较好，单位运营和财务状况良好。 经专家组评审，建议评审通过。\",\"companyName\": \"深圳古瑞瓦特新能源股份有限公司\",\"projectName\": \"新一代三相组串式光伏逆变器产业链关键环节提升项目\",\"projectSerialNo\": \"S0291222190627000A\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"69.16\",\"totalScore\": \"81.56\"},{\"auditComment\": \"该项目主要开展变电站智能辅助系统一体化平台建设研究，市场前景和社会效益较好，项目建设内容合理，具有一定的知识产权积累，但是项目研发团队实力有待加强，单位运营和财务状况一般。  经专家组评审，建议评审通过。\",\"companyName\": \"深圳市爱科赛科技股份有限公司\",\"projectName\": \"变电站智能辅助系统一体化平台建设研究\",\"projectSerialNo\": \"S02912221906260003\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"57.46\",\"totalScore\": \"67.66\"},{\"auditComment\": \"该项目主要开展新能源汽车车载电源集成一体机的相关研发和生产，市场前景和社会效益较好，项目建设内容合理，技术先进，项目团队具有较好的研发基础，知识产权等成果较好，单位运营和财务状况良好。  经专家组评审，建议评审通过。\",\"companyName\": \"深圳威迈斯新能源股份有限公司\",\"projectName\": \"新能源汽车车载电源集成一体机关键环节提升\",\"projectSerialNo\": \"S02912221906260007\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"66.81\",\"totalScore\": \"81.01\"},{\"auditComment\": \"该项目面向能量密度安全性手机电池开展相关关键技术研发，市场前景较好，建设内容合理，资金状况良好，项目研发团队基础较好，运营管理正常。 经专家组评审，建议评审通过。\",\"companyName\": \"深圳瑞隆新能源科技有限公司\",\"projectName\": \"高能量密度安全性手机电池关键技术研发与产业化项目\",\"projectSerialNo\": \"S02912221906280001\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"60.36\",\"totalScore\": \"72.76\"},{\"auditComment\": \"该项目开展氢燃料电池发动机系统在公共交通领域的应用研究，具有一定的市场前景。项目单位研发基础和研发团队一般，项目取得经济效益偏弱，需要加强产品的应用推广。经专家组评审，建议评审通过。\",\"companyName\": \"深圳国氢新能源科技有限公司\",\"projectName\": \"30kW氢燃料电池发动机系统在公共交通领域的应用研究\",\"projectSerialNo\": \"S0291222190627000H\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"55.6\",\"totalScore\": \"67\"},{\"auditComment\": \"该项目开展高效蓄冰储能系统的研发，具有一定的市场前景。项目单位具有一定 的研发基础，研发团队一般，项目取得一定的经济社会效益和技术成果。经专家组评审，建议评审通过。\",\"companyName\": \"深圳市鹏跃新能源科技有限公司\",\"projectName\": \"高效蓄冰储能系统产业链关键环节提升\",\"projectSerialNo\": \"S0291222190627000F\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"58.9\",\"totalScore\": \"69.3\"},{\"auditComment\": \"该项目开展高可靠性环保铁锂电池开发，具有较好的市场前景。项目单位具有较好的研发基础，建设内容和方案合理可行，项目取得了较好的经济和社会效益，获得多项自有知识产权。经专家组评审，建议评审通过。\",\"companyName\": \"深圳市朗泰沣电子有限公司\",\"projectName\": \"高可靠性环保铁锂电池产业链关键环节提升\",\"projectSerialNo\": \"S02912221906270010\",\"auditReportUrl\": [{\"url\":\"http://ps.szfetsc.com\"}],\"techScore\": \"65.58\",\"totalScore\": \"81.78\"},{\"auditComment\": \"        该公司申报的高效低耗锂离子动力电池生产项目市场前景较好，行业当中是领军企业，项目研发和技术团队配备合理，有相应的质量管理体系，管理机制较为成熟，项目资金能够得到落实，预期的经济效益和社会效益较好。经专家组评审，建议评审通过。\n" +
                "\n" +
                "\",\"companyName\"";
        System.out.println(str);
    }


}
