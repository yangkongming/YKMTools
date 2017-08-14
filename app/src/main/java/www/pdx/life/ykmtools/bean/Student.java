package www.pdx.life.ykmtools.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;

/**
 * <pre>
 *     author : wenxin
 *     e-mail : xxx@xx
 *     time   : 2017/03/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */

@Entity
public class Student {

	@Id
    private Long id;
	@NotNull
	private String name;
	@Transient
	private String age;
	public String getAge() {
		return this.age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Generated(hash = 225149174)
	public Student(Long id, @NotNull String name) {
		this.id = id;
		this.name = name;
	}
	@Generated(hash = 1556870573)
	public Student() {
	}

}
