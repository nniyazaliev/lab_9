import java.io.Serializable;

public class Animal implements Serializable {
	private String name;
	private String type;
	private Double weight;
	private Integer quantity;

	Animal() {}

	Animal(String name, String type, Double weight, Integer quantity) {
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Double getWeight() {
		return weight;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Это животное " + this.name + " из семейства " + this.type +
				" Вес " + this.weight + " и количество равняется " + this.quantity;
	}
}
