- Local Variables should not be declared and then immediately returned or thrown (squid:S1488)
局部变量不应该被声明，然后立即返回或抛出
例如：

```java
public static String getRelationShip(int relationId) {
		String typeName = RelationShipEnum.getNameByOrdinal(relationId);
		return typeName;
	}
```
改为直接返回

```java
	public static String getRelationShip(int relationId) {
		return RelationShipEnum.getNameByOrdinal(relationId);
	}

```


-Dead stores should be removed (squid:S1854)
