var window = {};
var compiledTemplate;
function render(template, model) {
	if (!compiledTemplate) {
		compiledTemplate = Handlebars.compile(template);
	}
	return compiledTemplate(model);
}