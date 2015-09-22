package sevencm.tools.test.chance;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sevencm.tools.chance.AliasChance;

public class ChanceTest {
	
	@Test
	public void test() {
		List<Double> prob = new ArrayList<Double>();
		prob.add(0.1);
		prob.add(0.2);
		prob.add(0.3);
		prob.add(0.01);
		prob.add(0.39);
		prob.add(0.00);
		prob.add(0.00);
		int[] cnt = new int[prob.size()];
		AliasChance am = new AliasChance(prob);


		for (int i = 0; i < 10000; i++) {
			cnt[am.next()]++;
		}
		for (int i = 0; i < cnt.length; i++)
			System.out.println("概率类型" + i + " " + cnt[i]);
	}
	
}
