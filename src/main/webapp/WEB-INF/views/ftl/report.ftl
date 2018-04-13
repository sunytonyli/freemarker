
			<!--  tr start-->
			${report.kinds?size}
			<#assign kinds = report.kinds>
			<#list kinds as kind>
				<#assign i = kind?index>
				${i}
				${report.kinds[i].kindName}
			</#list>
			
<#list 0..report.kinds?size-1 as i>
${i}
	${report.kinds[0].kindName}
</#list>