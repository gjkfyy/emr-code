package pkuhit.xap.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import pkuhit.iih.qa.QaRecord;
import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.md.DictionaryService;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.sv.log.DebugLogger;
import xap.sv.log.WarnLogger;
import xap.sv.util.BeanAttribute;

public class BeanCopyUtil {

	/**
	 * 属性 Copy 根据注解相同 Copy 属性的值
	 * 
	 * @param target
	 *            entity
	 * @param source
	 *            Model
	 */

	public static void modelToEntity(Object target, Object source) {
		/*
		 * 分别获得源对象和目标对象的Class类型对象,Class对象是整个反射机制的源头和灵魂！
		 * 
		 * Class对象是在类加载的时候产生,保存着类的相关属性，构造器，方法等信息
		 */

		if (source != null) {
			Class sourceClz = source.getClass();

			Class targetClz = target.getClass();

			List<BeanAttribute> sourceList = getSourceFields(sourceClz);
			// if(sourceList.size()== 0){
			// sourceList = getTargetFields(sourceClz);
			// }
			List<BeanAttribute> targetList = getTargetFields(targetClz);
			// if(targetList.size() == 0){
			// targetList = getSourceFields(targetClz);
			// }
			int targetNum = targetList.size();
			for (int i = 0; i < targetNum; i++) {
				BeanAttribute targetBean = targetList.get(i);
				Field targetField = targetBean.getField();
				targetField.getName();
				targetField.getType();
				int sourceNum = sourceList.size();
				for (int j = 0; j < sourceNum; j++) {
					BeanAttribute sourceBean = sourceList.get(j);
					Field sourceField = sourceBean.getField();
					Field sourceFieldType = getField(sourceClz,
							sourceBean.getName());
					Field targetFieldType = getField(targetClz,
							targetBean.getName());

					String getMethodName = getAttributeGetMethod(sourceBean
							.getName());
					String setMethodName = getAttributeSetMethod(targetBean
							.getName());
					Method getMethod = getGetMethod(sourceClz, getMethodName);
					Method setMethod = getSetMethod(targetClz, setMethodName,
							targetField);
					Object result;
					if (targetBean.getAnnoName().equals(
							sourceBean.getAnnoName())
							&& sourceFieldType.getType() == targetFieldType
									.getType()) {

						try {
							result = getMethod.invoke(source, new Object[] {});
							setMethod.invoke(target, result);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// 调用target对象的setMethod方法
					} else if (targetBean.getAnnoName().equals(
							sourceBean.getAnnoName())
							&& targetFieldType.getType() == java.sql.Timestamp.class
							&& sourceFieldType.getType() == java.util.Date.class) {
						try {
							result = getMethod.invoke(source, new Object[] {});
							if (result != null) {
								long time2 = ((Date) result).getTime();

								Timestamp time = new Timestamp(time2);
								// Timestamp time = Timestamp.valueOf(result
								// .toString());

								result = getMethod.invoke(source,
										new Object[] {});
								setMethod.invoke(target, time);
							}
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							System.out.println("sourceBean"
									+ sourceBean.getName());
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param targetModel
	 * @param sourceEntity
	 * @param ModelId
	 * @param dictionnaryService 传null后不进行code转name操作，在不需要name时可以节约执行时间
	 */
	public static void entityToModel(Object targetModel, Object sourceEntity,
			String ModeId, DictionaryService dictionaryService) {

		if (sourceEntity != null) {

			Class sourceClz = sourceEntity.getClass();

			Class targetClz = targetModel.getClass();

			List<BeanAttribute> sourceList = getTargetFields(sourceClz);

			List<BeanAttribute> targetList = getSourceFields(targetClz);

			int targetNum = targetList.size();
			for (int i = 0; i < targetNum; i++) {
				BeanAttribute targetBean = targetList.get(i);
				Field targetField = targetBean.getField();
				targetField.getName();
				targetField.getType();
				int sourceNum = sourceList.size();
				for (int j = 0; j < sourceNum; j++) {
					BeanAttribute sourceBean = sourceList.get(j);
					Field sourceField = sourceBean.getField();
					Field sourceFieldType = getField(sourceClz,
							sourceBean.getName());
					Field targetFieldType = getField(targetClz,
							targetBean.getName());

					String getMethodName = getAttributeGetMethod(sourceBean
							.getName());
					String setMethodName = getAttributeSetMethod(targetBean
							.getName());
					Method getMethod = getGetMethod(sourceClz, getMethodName);
					Method setMethod = getSetMethod(targetClz, setMethodName,
							targetField);

					Object result;
					if (targetBean.getAnnoName().equals(
							sourceBean.getAnnoName())
							&& sourceFieldType.getType() == targetFieldType
									.getType()) {

						try {
							result = getMethod.invoke(sourceEntity,
									new Object[] {});
							setMethod.invoke(targetModel, result);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// 调用target对象的setMethod方法
					} else if (targetBean.getAnnoName().equals(
							sourceBean.getAnnoName())
							&& targetFieldType.getType() == java.util.Date.class
							&& sourceFieldType.getType() == java.sql.Timestamp.class) {
						try {
							result = getMethod.invoke(sourceEntity,
									new Object[] {});
							if (result != null) {
								// Timestamp time=
								// Timestamp.valueOf(result.toString());
								SimpleDateFormat format = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss");

								result = getMethod.invoke(sourceEntity,
										new Object[] {});
								try {
									setMethod.invoke(targetModel,
											format.parse(result.toString()));
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

			// test 测试中
			if (null!=dictionaryService) {
				getCodeToName(ModeId, targetModel, dictionaryService);
			}
		}
	}

	/**
	 * Model 字段使用 xap.sv.annotation.Column 的注解 example // 任务目标数据主键
	 * 
	 * @Column(name="TGT_OB_PK") private String targetObjectPk;
	 * 
	 *                           MapToModel
	 * @param model
	 * @param map
	 */
	public static void mapToModel(Object model, Map map) {
		if (map != null) {
			Class modelClass = model.getClass();
			List<BeanAttribute> targetList = getSourceFields(modelClass);
			if (targetList != null) {
				for (BeanAttribute bean : targetList) {
					String setMethodName = getAttributeSetMethod(bean.getName());
					Method setMethod = getSetMethod(modelClass, setMethodName,
							bean.getField());
					if (map.get(bean.getAnnoName()) == null) {
						continue;
					}
					try {
						if ((bean.getField().getType() == java.util.Date.class || bean
								.getField().getType() == java.sql.Date.class)
								&& map.get(bean.getAnnoName()).getClass() != bean
										.getField().getType()) {
							// 时间类型的转换
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							try {
								java.sql.Timestamp tmp = (Timestamp) map
										.get(bean.getAnnoName());
								String tmp1 = tmp.toString();
								tmp1 = tmp1.substring(0, tmp1.length() - 1);
								setMethod.invoke(model, format.parse(tmp1));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							setMethod
									.invoke(model, map.get(bean.getAnnoName()));
						}
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

	}

	/**
	 * Model 字段使用 xap.sv.annotation.Column 的注解 example // 任务目标数据主键
	 * 
	 * @Column(name="TGT_OB_PK") private String targetObjectPk;
	 * 
	 *                           MapToModel
	 * @param model
	 * @param map
	 */
	public static void mapToModel(Object model, Map map,
			DictionaryService dictionaryService) {
		if (map != null) {
			Class modelClass = model.getClass();
			List<BeanAttribute> targetList = getSourceFields(modelClass);
			if (targetList != null) {
				for (BeanAttribute bean : targetList) {
					String setMethodName = getAttributeSetMethod(bean.getName());
					Method setMethod = getSetMethod(modelClass, setMethodName,
							bean.getField());
					try {
						if ((bean.getField().getType() == java.util.Date.class || bean
								.getField().getType() == java.sql.Date.class)
								&& map.get(bean.getAnnoName()) != null
								&& map.get(bean.getAnnoName()).getClass() != bean
										.getField().getType()) {
							// 时间类型的转换
							// SimpleDateFormat format = new SimpleDateFormat(
							// "yyyy-MM-dd HH:mm:ss");
							// try {
							// setMethod.invoke(model, ((Object) format
							// .parse((String) map.get(bean
							// .getAnnoName()))));
							// } catch (ParseException e) {
							// // TODO Auto-generated catch block
							// e.printStackTrace();
							// }
							Date date = (Date) map.get(bean.getAnnoName());
							setMethod.invoke(model, date);
						} else if (map.get(bean.getAnnoName()) != null) {
							if(map.get(bean.getAnnoName()) instanceof BigDecimal){
//								System.out.println(setMethodName);
//								System.out.println(bean.getField().getType());
								if(bean.getField().getType() == java.lang.Short.class){
									map.put(bean.getAnnoName(), ((BigDecimal)map.get(bean.getAnnoName())).shortValue());
									 
								}
								if(bean.getField().getType() == java.math.BigInteger.class){
									map.put(bean.getAnnoName(),  ((BigDecimal)map.get(bean.getAnnoName())).toBigInteger());
								}
								if(bean.getField().getType() == java.lang.Integer.class){
									System.out.println(map.get(bean.getAnnoName()).getClass());
									Integer integer = new Integer(((BigDecimal)map.get(bean.getAnnoName())).intValue());
									map.put(bean.getAnnoName(),  integer);
								}
								
							}
							setMethod.invoke(model, map.get(bean.getAnnoName()));
						}
					} catch (IllegalArgumentException e) {
//						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				// code 转换 名称
				getCodeToName("", model, dictionaryService);
			}

		}

	}

	/**
	 * 根据注解 DictionaryTag code 转换 名称
	 * 
	 * @param ModelId
	 * @param model
	 * @param dictionaryService
	 */
	private static void getCodeToName(String ModelId, Object model,
			DictionaryService dictionaryService) {

		List<BeanAttribute> list = getListDictionaryTag(model);
		// 一次赋值返回数组 前提 codes 里的值不能为空
		// if(list != null){
		// //get code
		// String[] codes = getCodeValues(model,list);
		// //code name
		// SimpleItem[] item = dictionaryService.getSimpleItems(ModelId, codes);
		// //set Name
		// setModelNames(model,item,list);
		// }

		if (list != null) {
			// get code
			for (int i = 0; i < list.size(); i++) {
				BeanAttribute bean = list.get(i);
				// get code
				String code = getCodeValue(model, bean);
				if (code != null)
                {
				    // code name
				    String dictId = bean.getObjCd();
				    if (StringUtils.isBlank(dictId))
				        continue;
//				    PerformancePrinter.start("dictionaryService");
				    // DIM01
				    if (null == code || "".equals(code)) {
				        // System.out.println(bean.getField().getType());
				        // System.out.println(bean.getName());
				        // System.out.println(bean.getObjCd());
				        // DebugLogger.log("code为null");
//				        WarnLogger.log(bean.getAnnoName() +"对应转换code为null");
				        // System.out.println(bean.getAnnoName());
				        continue;
				    }
				    SimpleItem[] item = dictionaryService.getSimpleItems(dictId,
				            code);
//				    System.out.println(dictId + "-" + code + "-" + item.length);
				    // SimpleItem[] item = dictionaryService.getSimpleItems("MRM03",
				    // "MRM03.01");
//				    PerformancePrinter.end("dictionaryService");
				    // set Name
				    setModelName(model, item, bean);
                }else {
                    WarnLogger.log(("code is null"));
                }
			}
		}
	}

	/**
	 * 得到注解是 DictionaryTag 属性 getListDictionaryTag
	 * 
	 * @param model
	 * @return
	 */
	private static List<BeanAttribute> getListDictionaryTag(Object model) {

		List<BeanAttribute> list = new ArrayList<BeanAttribute>();
		Class modelClass = model.getClass();
		Field[] fields = modelClass.getDeclaredFields();
		for (Field field : fields) {
			BeanAttribute bean = new BeanAttribute();
			DictionaryTag dictionaryTag = field
					.getAnnotation(DictionaryTag.class);
			if (dictionaryTag != null) {
				bean.setName(field.getName());
				bean.setAnnoName(dictionaryTag.code());
				bean.setObjCd(dictionaryTag.objCd());
				bean.setField(field);
				list.add(bean);
			}
		}
		return list;
	}

	/**
	 * 得到code value的 值
	 * 
	 * @param entity
	 * @param list
	 * @return
	 */
	private static String[] getCodeValues(Object entity,
			List<BeanAttribute> list) {

		String[] codes = {};
		if (list != null) {
			int size = list.size();
			codes = new String[size];
			for (int i = 0; i < size; i++) {
				BeanAttribute bean = list.get(i);
				String getMethodName = getAttributeGetMethod(bean.getAnnoName());
				Method getMethod = getGetMethod(entity.getClass(),
						getMethodName);
				try {
					Object obj = getMethod.invoke(entity, new Object[] {});
					if (obj != null) {
						codes[i] = obj.toString();
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return codes;
		}
		return codes;
	}

	/**
	 * 
	 * getCodeValue 得到code value的 值
	 * 
	 * @param entity
	 * @param list
	 * @return String
	 */
	private static String getCodeValue(Object model, BeanAttribute beanAttribute) {

		String code = "";
		if (beanAttribute != null) {
			String getMethodName = getAttributeGetMethod(beanAttribute
					.getAnnoName());
			Method getMethod = getGetMethod(model.getClass(), getMethodName);
			try {
				Object obj = getMethod.invoke(model, new Object[] {});
				if (obj != null) {
					code = obj.toString();
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return code;
		}
		return code;
	}

	/**
	 * setModelNames
	 * 
	 * code 转换 name
	 * 
	 * @param model
	 * @param simples
	 * @param list
	 */
	private static void setModelNames(Object model, SimpleItem[] simples,
			List<BeanAttribute> list) {
		if (simples.length > 0) {
			for (int i = 0; i < simples.length; i++) {
				SimpleItem simple = simples[i];

				BeanAttribute bean = list.get(i);
				String setName = getAttributeSetMethod(bean.getName());
				Method setMethod = getSetMethod(model.getClass(), setName,
						bean.getField());
				try {
					if (simple != null) {
						setMethod.invoke(model, simple.getText());
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * setModelName code 转换 name
	 * 
	 * @param model
	 * @param simples
	 */
	private static void setModelName(Object model, SimpleItem[] simples,
			BeanAttribute beanAttribute) {
		if (simples.length > 0) {
			for (int i = 0; i < simples.length; i++) {
				SimpleItem simple = simples[i];
				String setName = getAttributeSetMethod(beanAttribute.getName());
				Method setMethod = getSetMethod(model.getClass(), setName,
						beanAttribute.getField());
				try {
					if (simple != null) {
						setMethod.invoke(model, simple.getText());
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * getFields Column 得到Class对象所表征的类的所有属性(包括私有属性)
	 * 
	 * @param Clz
	 * @return
	 */
	private static List<BeanAttribute> getSourceFields(Class Clz) {
		List<BeanAttribute> list = new ArrayList();
		// 得到Class对象所表征的类的所有属性(包括私有属性)
		// Field[] fields = Clz.getDeclaredFields();
		// if (fields.length == 0) {
		// fields = Clz.getSuperclass().getDeclaredFields();
		// }
		Field[] fields = allFields(Clz);

		for (Field f : fields) {
			BeanAttribute bean = new BeanAttribute();
			// Column c = f.getAnnotation(Column.class);

			String key = f.getDeclaringClass().getCanonicalName() + "-"
					+ f.getName();
			Column c = AnnotationCache.getXap(key);
			if (c == null) {
				c = f.getAnnotation(Column.class);
			}

			if (c != null) {
				AnnotationCache.putXap(key, c);
				bean.setName(f.getName());
				bean.setAnnoName(c.name());
				bean.setField(f);
				list.add(bean);
			}
		}
		return list;
	}

	public static Field[] allFields(Class clz) {
		List<Field> afs = new ArrayList<Field>();
		Collections.addAll(afs, clz.getDeclaredFields());
		while (clz.getSuperclass() != null) {
			clz = clz.getSuperclass();
			Collections.addAll(afs, clz.getDeclaredFields());
		}
		return afs.toArray(new Field[afs.size()]);
	}

	/**
	 * getDomaFields doam 注解 得到Class对象所表征的类的所有属性(包括私有属性)
	 * 
	 * @param Clz
	 * @return
	 */
	private static List<BeanAttribute> getTargetFields(Class Clz) {
		List<BeanAttribute> list = new ArrayList();
		// 得到Class对象所表征的类的所有属性(包括私有属性)
		// Field[] fields = Clz.getDeclaredFields();
		Field[] fields = allFields(Clz);
		if (fields.length == 0) {
			fields = Clz.getSuperclass().getDeclaredFields();
		}
		for (Field f : fields) {
			BeanAttribute bean = new BeanAttribute();
			String key = f.getDeclaringClass().getCanonicalName() + "-"
					+ f.getName();
			org.seasar.doma.Column c = AnnotationCache.getDoma(key);
			if (c == null) {
				c = f.getAnnotation(org.seasar.doma.Column.class);
			}
			if (c != null) {
				AnnotationCache.putDoma(key, c);
				bean.setName(f.getName());
				bean.setAnnoName(c.name());
				bean.setField(f);
				list.add(bean);
			}
		}
		return list;
	}

	/**
	 * 属性的get方法
	 * 
	 * @param fieldName
	 * @return
	 */
	private static String getAttributeGetMethod(String fieldName) {
		String getMethodName = "";
		if (fieldName != null && fieldName != "") {
			getMethodName = "get" + fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);
			return getMethodName;
		}
		return getMethodName;
	}

	/**
	 * 属性的set方法
	 * 
	 * @param fieldName
	 * @return
	 */
	private static String getAttributeSetMethod(String fieldName) {
		String getMethodName = "";
		if (fieldName != null && fieldName != "") {
			getMethodName = "set" + fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);
			return getMethodName;
		}
		return getMethodName;
	}

	/**
	 * 
	 * @param Clz
	 * @param fieldName
	 * @return
	 */
	private static Field getField(Class Clz, String fieldName) {
		Field field = null;
		try {
			field = Clz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return getField(Clz.getSuperclass(), fieldName);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return field;
	}

	/***
	 * 得到Class 的getMenthod 方法
	 * 
	 * @param Clz
	 * @param getMethodName
	 * @return Method
	 */
	private static Method getGetMethod(Class Clz, String getMethodName) {
		Method getmeth = null;
		try {
			// try {
			getmeth = Clz.getDeclaredMethod(getMethodName, new Class[] {});
			// } catch (NoSuchMethodException e) {
			// getmeth = Clz.getSuperclass().getDeclaredMethod(getMethodName,
			// new Class[] {});
			// }
		} catch (SecurityException e) {
			e.printStackTrace();

		} catch (NoSuchMethodException e) {
			// e.printStackTrace();
			return getGetMethod(Clz.getSuperclass(), getMethodName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return getmeth;
	}

	/**
	 * 得到 Class 的setMethod 的方法
	 * 
	 * @param Clz
	 * @param setMethodName
	 * @param field
	 * @return Method
	 */
	private static Method getSetMethod(Class Clz, String setMethodName,
			Field field) {
		Method setmethod = null;
		try {
			// try {
			setmethod = Clz.getDeclaredMethod(setMethodName, field.getType());

			// } catch (NoSuchMethodException e) {
			// setmethod = Clz.getSuperclass().getDeclaredMethod(
			// setMethodName, field.getType());
			// }
		} catch (SecurityException e) {
			e.printStackTrace();

		} catch (NoSuchMethodException e) {
			// e.printStackTrace();
			return getSetMethod(Clz.getSuperclass(), setMethodName, field);

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return setmethod;
	}

	public static void main(String[] args) {
		Class<? super QaRecord> superclass = QaRecord.class.getSuperclass();
		System.out.println(superclass);
		System.out.println(allFields(QaRecord.class).length);
	}

}
