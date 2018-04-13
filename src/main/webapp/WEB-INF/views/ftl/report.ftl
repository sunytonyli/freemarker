
			<!--  tr start-->
			${report.kinds?size}
			<#assign kinds = report.kinds>
			<#list kinds as kind>
				<#assign i = kind?index>
				${i}
				${kind.kindName}
			</#list>
