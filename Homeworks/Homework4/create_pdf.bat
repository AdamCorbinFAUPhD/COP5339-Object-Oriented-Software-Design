pandoc  --verbose --toc ".\Adam Corbin COP 5330 - 004.md" -o final_report.pdf -f markdown+implicit_figures+link_attributes -F pandoc-plantuml.cmd --mathjax --listings -H listings-setup.tex
