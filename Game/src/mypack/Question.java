package mypack;

public class Question
{
	private String question,option_a,option_b,option_c,option_d,answer,answer_given;

	public Question(String question, String option_a, String option_b,
			String option_c, String option_d, String answer) {
		super();
		this.question = question;
		this.option_a = option_a;
		this.option_b = option_b;
		this.option_c = option_c;
		this.option_d = option_d;
		this.answer = answer;
		answer_given="";
	}

	public String getAnswer_given() {
		return answer_given;
	}

	public void setAnswer_given(String answer_given) {
		this.answer_given = answer_given;
	}

	public String getAnswer() {
		return answer;
	}

	public String getQuestion() {
		return question;
	}

	public String getOption_a() {
		return option_a;
	}

	public String getOption_b() {
		return option_b;
	}

	public String getOption_c() {
		return option_c;
	}

	public String getOption_d() {
		return option_d;
	}	
}