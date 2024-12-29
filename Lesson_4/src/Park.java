import java.util.ArrayList;

public class Park {
    private String parkInfo;
    private String workTime;

    public Park(String parkInfo, String workTime) {
        this.parkInfo = parkInfo;
        this.workTime = workTime;
    }

    public void setParkInfo(String parkInfo) {
        this.parkInfo = parkInfo;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }
    ArrayList<Attraction> attractions = new ArrayList<>();

    public void addAttraction(String attractionInfo, double cost, String workTime){
        new Attraction(attractionInfo, cost, workTime);
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkInfo='" + parkInfo + '\'' +
                ", workTime='" + workTime + '\'' +
                '}';
    }

    public class Attraction {
        private String attractionInfo;
        private double cost;
        private String workTime;

        public Attraction(String attractionInfo, double cost, String workTime) {
            this.attractionInfo = attractionInfo;
            this.cost = cost;
            this.workTime = workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public void setAttractionInfo(String attractionInfo) {
            this.attractionInfo = attractionInfo;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "attractionInfo='" + attractionInfo + '\'' +
                    ", cost=" + cost +
                    ", workTime='" + workTime + '\'' +
                    '}';
        }
    }
}
