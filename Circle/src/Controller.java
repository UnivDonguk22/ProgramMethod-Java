public class Controller {

	public void control(Model m, ViewIn i, ViewOut o) {
		int radius = i.getNumber("반지름을 주시면 원의 면적을 계산해드립니다.");
		double area = m.areaCircle(radius);
		o.show(radius, area);
	}

}