$first = [string](Invoke-Expression 'npm list -depth 0')
if (-Not ($first.Contains('css-loader'))) {
    npm install css-loader style-loader
}
webpack ./entry.js bundle.js --module-bind 'css=style!css'