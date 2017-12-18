package com.bruse.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ForEachTag extends BodyTagSupport{

	private Object items;
	private String var;
	//迭代器
	private Iterator<?> iterator;
	
	public Iterator<?> getIterator() {
		return iterator;
	}
	public void setIterator(Iterator<?> iterator) {
		this.iterator = iterator;
	}
	public Object getItems() {
		return items;
	}
	public void setItems(Object items) {
		if(items instanceof Collection<?>){
			this.iterator = ((Collection<?>)items).iterator();
		}else if(items instanceof Map<?, ?>){
			this.iterator = ((Map<?,?>)items).entrySet().iterator();
		}
		this.items = items;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		if(process()){
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
//		return super.doStartTag();
	}
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if(process()){
			//继续处理body，制作循环tag时有用
			return EVAL_BODY_AGAIN;
		}else{
			return SKIP_BODY;
		}
	}
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		pageContext.removeAttribute(var);
		return super.doEndTag();
	}
	
	private boolean process(){
		if(this.iterator!=null&&this.iterator.hasNext()){
			pageContext.setAttribute(var, iterator.next());
			return true;
		}else{
			return false;
		}
	}
}
